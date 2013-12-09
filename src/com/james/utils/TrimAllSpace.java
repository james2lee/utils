package com.james.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TrimAllSpace {
	private static BufferedReader bufferedReader;
	private static BufferedWriter bufferedWriter;
	private static String str = null;

	public static void main(String[] args) throws Exception {
		bufferedReader = new BufferedReader(new FileReader("C:\\Users\\Administrator\\Desktop\\���?ɽ11.txt"));
		bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\Administrator\\Desktop\\���?ɽ.txt"));
		move();
	}

	private static void move() throws FileNotFoundException, IOException {
		while ((str = bufferedReader.readLine()) != null) {
			if (str.length() != 0 && !str.contains("P��") && !str.contains("P:") && !str.contains("*") && !str.contains("��")) {
				str.replaceAll(" ", "");
				System.out.println(str);
				bufferedWriter.write(str);
				bufferedWriter.newLine();
			}

		}
		bufferedWriter.flush();
		bufferedReader.close();
		bufferedWriter.close();
	}
}
