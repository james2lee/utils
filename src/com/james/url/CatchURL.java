package com.james.url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CatchURL {

	public static void main(String[] args) {
		//URL地址
		String url = "http://www.itcast.cn";
		//HTML内容
		StringBuffer content = new StringBuffer();
		//存放网址的List
		List<String> urlList = new ArrayList<String>();
		try {
			//建立连接
			URL httpUrl = new URL(url);
			HttpURLConnection connection = (HttpURLConnection) httpUrl.openConnection();
			connection.connect();
			//打开网页数据流
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String string = "";
			//读入网页内容
			while ((string = bufferedReader.readLine()) != null) {
				content.append(string);
			}
			//关闭数据流
			bufferedReader.close();
			//根据内容抓取URL连接
			String contentString = content.toString();
			Pattern pattern = Pattern.compile("http://(([a-zA-z0-9]|-){1,}\\.){1,}[a-zA-z0-9]{1,}-*");
			Matcher matcher = pattern.matcher(contentString);
			while (matcher.find()) {
				String url2 = matcher.group();
				urlList.add(url2);
				System.out.println(url2);
			}
			
			System.out.println(urlList.size());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
