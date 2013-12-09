package com.james.utils;

import java.util.regex.Pattern;

public class TestRegex {

	public static void main(String[] args) {
		//匹配电子邮箱的正则表达式
		String email = "li.jian.yong@163.com.cn";
		String reg_email = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
		System.out.println(email.matches(reg_email));
		
		//匹配URL地址的正则表达式
		String url = "https://www.163.com.cn";
		String reg_url = "[a-zA-Z]+://[^\\s]*";	
		System.out.println(url.matches(reg_url));
		
		//split()，以空格来分割字符串
		String s = "GET /index.html HTTP/1.1";
//		String[] strings = s.split(" +");	//一个参数来分割
		String[] strings = s.split(" +",3);	//以两个参数来分割，并限定数组的长度
		for (String string : strings) {
			System.out.println(string);
		}
		
		//replaceAll()和replaceFirst()
		System.out.println(email.replaceAll(reg_email, "aaaa"));
		
		
	}
}
