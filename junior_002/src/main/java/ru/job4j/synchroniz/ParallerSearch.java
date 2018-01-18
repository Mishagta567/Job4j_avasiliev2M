package ru.job4j.synchroniz;


import com.sun.jmx.remote.internal.ArrayQueue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

import static javafx.scene.input.KeyCode.Q;

/**
 * Класс хранилища пользователей UserStorage [#1104]
 * @author   A_Vasiliev
 * @since    16.01.2018
 * @version  1.0.0
 */


public class ParallerSearch {
	private static String pathName = "C:\\projects\\tempFiles";
	static String searchWord;
	private String list[];
	private Queue<String> allFileNames = new LinkedList<String>();
	private Queue<String> resultFileNames = new LinkedList<String>();

	public String getFileName() {
		String result = null;
		if (!this.allFileNames.isEmpty()) {
			result = allFileNames.remove();
		}
		return result;
	}

	public ParallerSearch(String root, String text, List<String> exts) {
		this.list = new File(root).list();
		this.searchWord = text;
		int temp;	// для простоты дебага и проверок.

		for (int indx = 0; indx < this.list.length; indx++) {
			if (exts.size() > 0) {
				for (int extsIndx = 0; extsIndx < exts.size(); extsIndx++) {
					// проверяем: имеет ли данный файл нужное нам расширение
					temp = this.list[indx].length() - exts.get(extsIndx).length() - this.list[indx].lastIndexOf(exts.get(extsIndx));
					if (temp == 0) {
						allFileNames.add(this.list[indx]);
						break;
					}
						//System.out.println(test.length() - test.lastIndexOf("cde") - "cde".length() == 0);
				}
			}
		}
	}

	public static boolean checkOneFile(File file) throws FileNotFoundException, IOException {
		//FileInputStream fis = new FileInputStream(new File("C:\\projects\\tempFiles\\test_8.txt"));
		FileInputStream fis = new FileInputStream(file);
		byte[] content = new byte[fis.available()];
		fis.read(content);
		fis.close();
		boolean result = false;

		String[] lines = new String(content, "Cp1251").split("\n"); // кодировку указать нужную
		int i = 1;
		for (String line : lines) {

			// По непонятной причине на след. строке программа прекращает работать. Выкидывает.
			if (line.contains(ParallerSearch.searchWord)) {
				result = true;
				break;
			}		// */

			// При желании... с какой-то целью... можно проверять каждое слово:
			/** String[] words = line.split(" ");
			int j = 1;
			for (String word : words) {
				if (word.equalsIgnoreCase(ParallerSearch.searchWord)) {
					//System.out.println("Найдено в " + i + "-й строке, " + j + "-е слово");
					result = true;
					break;
				}
				j++;
				if (result) {
					break;
				}
			}
			i++;  //  */
		}
		return result;
	}

	public void searchThrOne() throws InterruptedException, IOException {
		String fileName;  // = this.getFileName();
		boolean rslt;
		while (!this.allFileNames.isEmpty()) {
			synchronized (this.allFileNames) {
				fileName = this.pathName + "\\" + this.getFileName();
			}
			rslt = this.checkOneFile(new File(fileName));
			if (rslt) {
				synchronized (this.resultFileNames) {
					resultFileNames.add(fileName);
				}
			}
		}
	}

	// Этот метод совсем не обязателен. Его можно удалить. Можно запускать одинаковые.
	public void searchThrTwo() throws IOException, InterruptedException {
		String fileName2;  // = this.getFileName();
		boolean rslt;
		while (!this.allFileNames.isEmpty()) {
			synchronized (this.allFileNames) {
				fileName2 = this.pathName + "\\" + this.getFileName();
			}
			// полностью повторяется предыдущий пакет.
			rslt = this.checkOneFile(new File(fileName2));
			if (!rslt) {   // просто переделал что бы было хоть какое-то отличие
				rslt = false;   // глупость для отладки
			} else {
				synchronized (this.resultFileNames) {
					resultFileNames.add(fileName2);
				}
			}
		}
	}		//  */

	public static void main(String[] args) throws IOException, InterruptedException {
		List<String> ext = new ArrayList<String>();
		ext.add("txx");
		ext.add("bat");
		final ParallerSearch ps = new ParallerSearch("C:\\projects\\tempFiles", "qwerty", ext);

		// я бы запускал несколько одинаковых потоков. Пусть проверяют тест.
		new Thread() {
			@Override
			public void run() {
				try {
					ps.searchThrOne();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println("ThreadOne: " + ps.resultFileNames.size());
			}
		}.start(); //  */


		// Второй:
		new Thread() {
			@Override
			public void run() {
				try {
					ps.searchThrTwo();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println("ThreadTwo: " + ps.resultFileNames.size());
			}
		}.start(); //  */

		//ps.searchThrOne();
		System.out.println("Main: " + ps.resultFileNames.size());

	}

}