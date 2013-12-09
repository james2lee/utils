package com.james.url;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class Down2011CaseMeshTread extends Thread {

	public static int count = 0;
	public static List<String> docDoiList = getCaseDoiList2();
	private static URL url;
	private static String doi;
	static int BUFFER_SIZE = 1024 * 10;

	public Down2011CaseMeshTread(String doi) {
		String urlStr = "http://www.sina.com/"/* + doi*/;
		try {
			this.url = new URL(urlStr);
			this.doi = doi;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws Exception {
		//连接数据库的   
		return null;
	}

	public static String getDocNameByDoi(String docDoi) {
		//获得docDoi对应的文件名，就是下载下来之后文件的存储名字  
		return "1.txt";
	}

	public void Test() {

		StringBuffer sb = null;
		BufferedReader in = null;
		BufferedWriter out = null;
		try {
			sb = new StringBuffer();
			int ch = 0;
			URLConnection conn = url.openConnection();
			conn.setRequestProperty("User-Agent", "Mozilla/4.76");
			conn.setDoOutput(true);
			conn.setConnectTimeout(1000 * 60 * 10);
			in = new BufferedReader(new InputStreamReader(url.openStream()));
			FileOutputStream fo = new FileOutputStream("D:/aaa/" + getDocNameByDoi(doi));
			OutputStreamWriter writer = new OutputStreamWriter(fo, "GB2312");
			out = new BufferedWriter(writer);
			while (!in.ready()) {
				Thread.sleep(500); // wait for stream to be ready.    
			}
			char[] buffer = new char[BUFFER_SIZE];
			int charsRead = 0;
			while ((charsRead = in.read(buffer, 0, BUFFER_SIZE)) != -1) {
				out.write(buffer, 0, charsRead);
			}
			out.close();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void run() {
		Test();
	}

	//应该是run()这里的问题，但我不知道改怎么改？？？？    

	public static List<String> getCaseDoiList2() {
		//获得url链表，一共五万多   
		List<String> urlList = new ArrayList<String>();
		urlList.add("http://cd.itcast.cn");
		urlList.add("http://gz.itcast.cn");
		urlList.add("http://bj.itcast.cn");
		urlList.add("http://sh.itcast.cn");
		return urlList;
	}

	public static void main(String args[]) throws MalformedURLException {
		for (String docDoi : docDoiList) {
			Down2011CaseMeshTread down = new Down2011CaseMeshTread(docDoi);
			down.start();
		}
	}
}