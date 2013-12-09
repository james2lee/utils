package com.james.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 测试是否为合法的身份证号码
 * @author James Lee
 *
 */
public class MatcherPersonID {

	public static void main(String[] args) {
		String[] id = {"432801197812141014","430723800914482","431024200805013334"}; 
		Pattern pattern = Pattern.compile("(\\d{17}[0-9a-zA-Z]|\\d{14}[0-9a-zA-Z])");
		for (String string : id) {
			Matcher matcher = pattern.matcher(string);
			System.out.println(string +":"+matcher.matches() );
			if (matcher.matches()) {
				if (string.length() == 18) {
					String birthday = string.substring(6, 14);
					String year = birthday.substring(0, 4);
					String month = birthday.substring(4, 6);
					String day = birthday.substring(6);
					System.out.println(year+"年"+month+"月"+day+"日");
				}else {
					String birthday = string.substring(6, 12);
					String year = birthday.substring(0, 2);
					String month = birthday.substring(2, 4);
					String day = birthday.substring(4);
					System.out.println(year+"年"+month+"月"+day+"日");
				}
			}
		}
	}
}
