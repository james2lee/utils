/**
 * 一些操作文件以及IO流的方法汇总
 */
package com.james.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author James Lee
 * 
 */
public class FileUtils {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		byteStreamFileWriteTest();
//		byteStreamFileReadTest();
//		charStreamFileWriteTest();
//		charSteamFileReadTest();
//		copyTextFileTest();
		copyBinaryFileTest();
	}

	public static void copyBinaryFileTest() {
		FileUtils fileUtils = new FileUtils();
		String sourcePath = new String("D:/[Java2游戏编程].(Java.2.Game.Programming).(美)Thomas.Petchel.扫描版.pdf");
		String destPath = new String("D:/Java2游戏编程.pdf");
		fileUtils.copyBinaryFile(sourcePath, destPath);
	}

	public static void copyTextFileTest() {
		FileUtils fileUtils = new FileUtils();
		String sourcePath = new String("D:/实训题库整理版.doc");
		String destPath = new String("D:/Java2游戏编程.doc");
		fileUtils.copyTextFile(sourcePath, destPath);
	}

	public static void charSteamFileReadTest() {
		FileUtils fileUtils = new FileUtils();
		String path = "D:/222.txt";
		String content = fileUtils.charStreamFileRead(path);
		System.out.println("FileUtils.charStreamFileWriteTest():   "+content);
	}

	public static void charStreamFileWriteTest() {
		FileUtils fileUtils = new FileUtils();
		String path = "D:/222.txt";
		String content = "我是一个小码农，小码农！";
		fileUtils.charStreamFileWrite(path, content);
		System.out.println("FileUtils.charStreamFileWriteTest():  文件输出成功！内容为：  " + content);
	}

	public static void byteStreamFileReadTest() {
		FileUtils fileUtils = new FileUtils();
		String source="D:/111.txt";
		String info = fileUtils.byteStreamFileRead(source);
		System.out.println("FileUtils.byteStreamFileReadTest():  "+info);
	}

	public static void byteStreamFileWriteTest() {
		FileUtils fileUtils = new FileUtils();
		String dest = "D:/111.txt";
		String content = "this is a james lee program!";
		fileUtils.byteStreamFileWrite(dest, content);
		System.out.println("FileUtils.byteStreamFileWriteTest():  文件输出成功！内容为：  " + content);
	}

	/**
	 * 把info通过字节流的方式写入到path指定的文件中去
	 * 
	 * @param path
	 *            指定的文件路径
	 * @param info
	 *            指定的要写入的内容
	 */
	public void byteStreamFileWrite(String path, String info) {
		File file = new File(path);
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			OutputStream outputStream = new FileOutputStream(file);
			byte[] bytes = info.getBytes();
			outputStream.write(bytes);
			outputStream.flush();
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 通过字节流,读取由path指定的文件
	 * 
	 * @param path
	 *            指定的文件路径
	 * @return String 返回读取的内容
	 */
	public String byteStreamFileRead(String path) {
		StringBuffer stringBuffer = new StringBuffer();// 线程非安全
		try {
			File file = new File(path);
			if (!file.exists()) {
				stringBuffer.append("文件不存在！");
				return stringBuffer.toString();
			}
			InputStream inputStream = new FileInputStream(file);
			int total = inputStream.available();
			char[] content = new char[total];
			for (int i = 0; i < total; i++) {
				char c = (char) inputStream.read();// 把int的字节转换成char
				content[i] = c;
			}
			inputStream.close();
			stringBuffer.append(String.valueOf(content));
		} catch (FileNotFoundException e) {
			new RuntimeException("文件不存在！");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return stringBuffer.toString();
	}

	/**
	 * 通过字符流的方式，把info指定的信息输出到path指定的文件中去
	 * 
	 * @param path
	 *            指定的文件路径
	 * @param info
	 *            指定的要写入的内容
	 */
	public void charStreamFileWrite(String path, String info) {
		try {
			File file = new File(path);
			if (!file.exists()) {
				file.createNewFile();
			}
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
			bufferedWriter.write(info);
			bufferedWriter.flush();
			bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 通过字符流的方式，读取path指定的文件
	 * 
	 * @param path
	 *            指定的文件路径
	 * @return String 返回读取的内容
	 */
	public String charStreamFileRead(String path) {
		StringBuffer stringBuffer = new StringBuffer();
		try {
			File file = new File(path);
			if (!file.exists()) {
				stringBuffer.append("File not exists.");
				return stringBuffer.toString();
			}
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
			String string = "";
			while ((string = bufferedReader.readLine()) != null) {
				stringBuffer.append(string + "\n");
			}
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return stringBuffer.toString();
	}

	/**
	 * 文件拷贝
	 * 
	 * @param sourcePath
	 *            源文件路径
	 * @param destPath
	 *            目标文件路径
	 */
	public void copyTextFile(String sourcePath, String destPath) {
		try {
			FileUtils fileUtils = new FileUtils();
			File destFile = new File(destPath);
			if (!destFile.exists()) {
				destFile.createNewFile();
			}
			// 读文件
			String read = fileUtils.charStreamFileRead(sourcePath);
			// 写文件
			fileUtils.charStreamFileWrite(destPath, read);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 二进制文件的复制
	 * @param sourcePath 源文件
	 * @param destPath 目标文件
	 */
	public void copyBinaryFile(String sourcePath,String destPath) {
		try {
			File sourceFile = new File(sourcePath);
			File destFile = new File(destPath);
			if (!destFile.exists()) {
				destFile.createNewFile();
			}
			BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(sourceFile));
			BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(destFile));
			int len = 0;
			byte[] bytes = new byte[1024*5];
			while ((len = bufferedInputStream.read(bytes)) !=-1) {
				bufferedOutputStream.write(bytes, 0, len);
				bufferedOutputStream.flush();
			}
			bufferedInputStream.close();
			bufferedOutputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
