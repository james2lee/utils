package com.james.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class TrimText
{
	private static BufferedReader bufferedReader;
	private static BufferedWriter bufferedWriter;
	private static String str = null;

	
	public static void main(String[] args) throws Exception
	{
		bufferedReader = new BufferedReader(new FileReader("C:\\Users\\Administrator\\Desktop\\1.txt"));
		bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\Administrator\\Desktop\\3.txt",true));
	
		move();
	}

	
	private static void move() throws FileNotFoundException, IOException
	{
		while ((str = bufferedReader.readLine()) != null)
		{
			if (str.length() > 0) {
				if (!str.contains("更多精彩，更多好书，尽在奇书网—http://Www.Qisuu.Com" )) {
					System.err.println(str);
					bufferedWriter.write(str);
					bufferedWriter.newLine();
				}
				
			}
		
		}
		bufferedWriter.flush();
		bufferedReader.close();
		bufferedWriter.close();
	}
}
