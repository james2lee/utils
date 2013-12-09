package com.james.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class RenameFiles {
	public static void main(String[] args) throws Exception {
		File file = new File("J:\\Kugou\\汽车HI-FI音乐");
		Long startTime = System.currentTimeMillis();
		// 将目录中的所有包含特定字符串的文件重命名
		 renameFileName(file,"|-");
		// 将文件拷贝到指定的目录中
		//copyFiles(new File("E:/111"), new File("E:/111/"));
		Long endTime = System.currentTimeMillis();
		System.out.println("耗时: " + (endTime - startTime));
	}

	public static void copyFile(File src, String dest) throws Exception {
		FileInputStream in = new FileInputStream(src);
		File file = new File(dest);
		if (!file.exists())
			file.createNewFile();
		FileOutputStream out = new FileOutputStream(file);
		int len;
		byte buffer[] = new byte[1024];
		while ((len = in.read(buffer)) != -1) {
			out.write(buffer, 0, len);
		}
		in.close();
		out.close();
	}

	public static void copyFiles(File srcFile, File destPath) throws Exception {
		List<File> fileList = new ArrayList<File>();
		File[] file = srcFile.listFiles();
		for (File files : file) {
			System.out.println(files.getName());
			if (files.isDirectory()) {
				// copyFiles(files, destPath);
			} else if (files.isFile()) {
				fileList.add(files);
				for (File file1 : fileList) {
					// if (file1.getName().endsWith(".ppt")) {
					System.out.println("--->" + file1.getName());
					FileInputStream in = new FileInputStream(file1);
					 if (!destPath.exists()) {
						 destPath.createNewFile();
					 }
					FileOutputStream out = new FileOutputStream(destPath);
					int len = 0;
					byte buffer[] = new byte[1024];
					while ((len = in.read(buffer)) != -1) {
						out.write(buffer, 0, len);
					}
					out.flush();
					in.close();
					out.close();
				}
				// }
			}
		}
	}

	/**
	 * 将目录中的所有包含特定字符串的文件重命名
	 * 
	 * @param file
	 * @param prefix
	 */
	public static void renameFileName(File file, String prefix) {
		// 目录路径
		String dirPath = file.getAbsolutePath();
		// 获取此目录下的文件列表
		File[] files = file.listFiles();
		// 遍历所有的文件
		for (File fileFrom : files) {
			// 如果是目录,递归遍历
			if (fileFrom.isDirectory()) {
				renameFileName(fileFrom, "--" + prefix);
			}
			// 得到单个文件名
			String fromFile = fileFrom.getName();
			System.out.println(prefix + fromFile);
			// 如果文件名里包含[www.ed2kers.com],则更改文件名
			String subContain = " - 【www.51ctzs.com】";
			if (fromFile.contains(subContain)) {
				// 得到后缀名。得到文件的扩展名
				String endwithString = fromFile.substring(fromFile.length() - 4, fromFile.length());
				// 得到排除[www.ed2kers.com]之外的文件名
				String startWithString = fromFile.substring(0, fromFile.length() - (subContain.length()+4));
				int index = fromFile.indexOf(".");
				// 文件名的组成
				fromFile = startWithString + endwithString;
				if (index != -1)// 防止有的文件名没有
				{
					// 改名后的文件名(路径+文件全名)
					String toFileName = dirPath + "\\" + fromFile;
					File toFile = new File(toFileName);
					// 改名后的文件没有重名,则更改
					if (fileFrom.exists() && !toFile.exists()) {
						// 开始更名
						fileFrom.renameTo(toFile);
					}
				}

			}
		}

	}
}
