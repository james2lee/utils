package com.james.utils;

import java.io.File;
import java.io.FilenameFilter;

/**
 * 图片文件过滤器
 * @author James Lee
 *
 */
public class ImageFileFilter implements FilenameFilter {

	public static void main(String[] args) {
		File filePath = new File("J:/相册/20091007_018老家");
		ImageFileFilter imageFileFilter = new ImageFileFilter();
		File[] files = filePath.listFiles(imageFileFilter);
		int i = 1;
		for (File file : files) {
			System.out.println(i+": "+file);
			i++;
		}
	}
	
	
	/**
	 * 是否jpg文件
	 * @param filename
	 * @return
	 */
	public boolean isJPG(String filename) {
		if (filename.toLowerCase().endsWith(".jpg")) {
			return true;
		}
		return false;
	}
	
	/**
	 * 是否bmp文件
	 * @param filename
	 * @return
	 */
	public boolean isBMP(String filename) {
		if (filename.toLowerCase().endsWith(".bmp")) {
			return true;
		}
		return false;
	}
	
	/**
	 * 是否gif文件
	 * @param filename
	 * @return
	 */
	public boolean isGIF(String filename) {
		if (filename.toLowerCase().endsWith(".gif")) {
			return true;
		}
		return false;
	}
	
	/**
	 * 是否bmp文件
	 * @param filename
	 * @return
	 */
	public boolean isPNG(String filename) {
		if (filename.toLowerCase().endsWith(".png")) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean accept(File dir, String name) {
		return (isBMP(name) || isGIF(name) || isJPG(name) || isPNG(name));
	}

}
