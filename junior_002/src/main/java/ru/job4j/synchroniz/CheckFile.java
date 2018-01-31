package ru.job4j.synchroniz;


import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Поиск текста в файле. [#1106]
 * @author   A_Vasiliev
 * @since    16.01.2018
 * @version  1.0.0
 */


public class CheckFile {
	String fileName;

	public CheckFile(String fileNm) {
		this.fileName = fileNm;
	}

	// checkFile возвращает true если в тексте есть искомая строка searchText
	public boolean checkFile(String searchText) throws IOException {
		String textLine;
		boolean result = false;
		try {
			File file = new File(fileName);
			BufferedReader br = new BufferedReader(new FileReader(file));
			while ((textLine = br.readLine()) != null) {
				if (textLine.contains(searchText)) {
					result = true;
					break;
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.printf("File not found %s", fileName);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.printf("Can't read line from frile %s", fileName);
			e.printStackTrace();
		}
		return result;
	}

}