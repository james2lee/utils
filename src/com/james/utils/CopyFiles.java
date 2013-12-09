package com.james.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Vector;

public class CopyFiles {
	// 已有文件的路径,需要备份到那个路径的名字
	private String fromFilePath = "";
	private String toFilePath = "";
	// 保存已有文件路径下的所有的文件的名字 存放String
	private Vector<String> vec = new Vector<String>();

	public static void main(String[] args) throws Exception {
		CopyFiles copyFiles = new CopyFiles("E:/111", "E:/111/aaa");
		copyFiles.getFileName();
		Vector<String> ve = new Vector<String>();
		ve = copyFiles.vec;
		if (ve != null)
			for (int i = 0; i < ve.size(); i++) {
				System.out.println((String) ve.elementAt(i));
				copyFiles.copyFile((String) ve.elementAt(i));
			}
	}

	public CopyFiles() {}

	public CopyFiles(String fromFilePath, String toFilePath) {
		this.fromFilePath = fromFilePath;
		this.toFilePath = toFilePath;
	}

	// 得到目录下所有文件的名字
	private void getFileName() {
		File f = new File(fromFilePath);
		String str[] = f.list();
		for (int i = 0; i < str.length; i++) {
			vec.addElement(str[i]);
		}
		System.out.println(vec.toString());
	}

	// 文件的拷贝:::测试成功
	private boolean copyFile(String fileName) throws Exception {

		// 读文件
		FileReader fileReader = new FileReader(fromFilePath + fileName);
		String detail = "";
		BufferedReader buff = new BufferedReader(fileReader);
		String temp = buff.readLine();
		while (temp != null) {
			detail += temp + "/n";
			temp = buff.readLine();
		}
		fileReader.close();
		System.out.println(detail);
		// 写文件
		File file = new File(toFilePath + fileName);
		PrintWriter out = new PrintWriter(new FileWriter(file));
		out.print(detail);
		out.close();

		return true;
	}

}