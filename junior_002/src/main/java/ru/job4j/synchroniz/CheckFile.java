package ru.job4j.synchroniz;


import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Класс хранилища пользователей UserStorage [#1104]
 * @author   A_Vasiliev
 * @since    16.01.2018
 * @version  1.0.0
 */


public class CheckFile {
	String fileName;

	public CheckFile(String fileNm) {
		this.fileName = fileNm;
	}

	public boolean checkFile(String searchText) throws IOException {
		String textLine;
		boolean result = false;
		String temp; // только для дебагинга

		try {
			// decleare a file
			File file = new File(fileName);
			// open a file
			BufferedReader br = new BufferedReader(new FileReader(file));
			// read a line

			while ((textLine = br.readLine()) != null) {
				temp = "-";
				if (textLine.contains(searchText)) {
					result = true;
					break;
				} else {
					temp = "la la la";
				}

			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.printf("File not found %s", fileName);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.printf("Can't read line from frile %s", fileName);
			e.printStackTrace();
		} //finally {
			// finish reading file;		}
		return result;
	}

}