package com.james.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
	private static BufferedInputStream bufferedInputStream = null;
	private static BufferedOutputStream bufferedOutputStream = null;
	public static void main(String[] args) {
		try {
			long startTime = System.currentTimeMillis();
			File sourceFile = new File("D:/[Java2游戏编程].(Java.2.Game.Programming).(美)Thomas.Petchel.扫描版.pdf");
			File destFile = new File("D:/[Java2游戏编程].扫描版.pdf");
			bufferedInputStream = new BufferedInputStream(new FileInputStream(sourceFile));
			bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(destFile));
			System.out.println("Copy " + sourceFile.length() / 1024.0 / 1024.0 + "MB");
			try {
				byte[] buf = new byte[1024*4];
				int len=0;
				while ((len = bufferedInputStream.read(buf)) != -1) {
					bufferedOutputStream.write(buf,0,len);
				}
				
				System.out.println("Copy " + destFile.length() / 1024.0 / 1024.0 + "MB finished!");
				long finishTime = System.currentTimeMillis();
				System.out.println("Durant time: " + (finishTime - startTime) / 1000.00 + "s.");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(0);
		}finally {
			try {
				bufferedOutputStream.flush();
				bufferedInputStream.close();
				bufferedOutputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
