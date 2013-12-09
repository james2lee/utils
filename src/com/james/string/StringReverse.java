package com.james.string;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.StringTokenizer;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.RestoreAction;



public class StringReverse {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		String s = "123";
//		System.out.println(Integer.parseInt(s));
//		System.out.println(Double.parseDouble(s));
//		System.out.println(String.valueOf(123));
/*		Double d = 10.022222;
		roundup1(d);
		roundup2(d);
		System.currentTimeMillis();
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DATE);
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		System.out.println(year+":"+month+":"+day+":"+hour+":"+minute+":"+second);
		calendar.set(Calendar.DATE, 1);	//把一号设为第一天
		calendar.roll(Calendar.DATE, -1);	//回滚一天则为上个月最后一天
		int lastDateOfMonth = calendar.get(Calendar.DATE);
		System.out.println("LastDateOfMonth: "+lastDateOfMonth);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年mm月dd日  hh点mm分ss秒");
		String date = dateFormat.format(new Date(System.currentTimeMillis()));
		System.out.println(date);*/
		String path = "I:/下载";
		//listAllFiles("|--",path);
//		listDirectory(path);
//		File sourceFile = new File("I:\\JAVA视频\\oracle/[CBT.Nuggets出品甲骨文11g数据库1Z0-051SQL基础考试视频教程].TLF-SOFT-CBT.Nuggets.Oracle.Database.11g.SQL.Fundamentals.1.1Z0-051-ACADEMY.iso");
//		File destFile = new File("J:/aa.iso");
//		copyFile(sourceFile,destFile);
		
//		JDBCUtils();
		
		Properties prop = System.getProperties();
		Set<Entry<Object, Object>> set = prop.entrySet();
		Iterator<Entry<Object, Object>> it = set.iterator();
		while (it.hasNext()) {
			Map.Entry<Object, Object> entry = (Map.Entry<Object, Object>) it.next();
			String key = (String) entry.getKey();
			String value = (String) entry.getValue();
			System.out.println(key + "<-->" + value);
		}

		long end = System.currentTimeMillis();
		System.out.println((end-start)/1000.0);
	}

	private static void JDBCUtils() {
		try {
			String url = "jdbc:mysql://localhost:3306/user";
			String user = "root";
			String password = "root";
			String sql = "select * from user";
			String sql1 = "select * from user where username=?";
			//加载数据库的驱动，并注册到DriverManager中
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			//建立数据库连接，取得Connection对象
			Connection connection = DriverManager.getConnection(url, user, password);
			//建立Statement对象
//			Statement statement = connection.createStatement();
			PreparedStatement statement = connection.prepareStatement(sql1);
			statement.setString(1, "james");
			//执行SQL语句
			ResultSet resultSet = statement.executeQuery();
//			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Integer id = resultSet.getInt("id");
				String email = resultSet.getString("email");
				String nickname = resultSet.getString("nickname");
				String pw = resultSet.getString("password");
				String username = resultSet.getString("username");
				System.out.println(id+":"+email+":"+nickname+":"+pw+":"+username);
			}
			resultSet.close();
			statement.close();
			connection.close();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static String whatEncode(String string) {
		
		try {
			String encode = "UTF-8";
			if (string.equals(new String(string.getBytes(encode),encode))) {
				return encode;
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		try {
			String encode = "ISO8859-1";
			if (string.equals(new String(string.getBytes(encode),encode))) {
				return encode;
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		try {
			String encode = "GBK2312";
			if (string.equals(new String(string.getBytes(encode),encode))) {
				return encode;
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "";
	}

	private static void copyFile(File sourceFile, File destFile) {
		BufferedInputStream bufferedInputStream = null;
		BufferedOutputStream bufferedOutputStream = null;
		try {
			bufferedInputStream = new BufferedInputStream(new FileInputStream(sourceFile));
			bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(destFile));
			byte[] bytes = new byte[1024*4];
			int len = 0;
			while ((len = bufferedInputStream.read(bytes)) != -1) {
				bufferedOutputStream.write(bytes, 0, len);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				bufferedInputStream.close();
				bufferedOutputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 列出目录下的所有目录
	 @param path
	 */
	private static void listDirectory(String path) {
		File[] files = new File(path).listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				System.out.println(file);	//输出当前目录
				listDirectory(file.getAbsolutePath());	//递归调用，查找下一级目录
			}
		}
	}

	/**
	 * 列出目录下的所有文件
	 @param prefix
	 @param path
	 */
	private static void listAllFiles(String prefix,String path) {
		File[] file = new File(path).listFiles();//得到所有的目录和文件
		for (File file2 : file) {
			System.out.println(prefix+file2.getName());
			if (file2.isDirectory()) {
				listAllFiles("|--"+prefix,file2.getPath());
			}
		}
	}

	/**
	 * Double数值取小数点后两位，并四舍五入
	 @param d
	 */
	private static void roundup2(Double d) {
		DecimalFormat decimalFormat = new DecimalFormat("#.##");
		System.out.println(decimalFormat.format(d));
	}
	
	/**
	 * Double数值取小数点后两位，并四舍五入
	 @param d
	 */
	private static void roundup1(Double d) {
		DecimalFormat decimalFormat = new DecimalFormat();
		decimalFormat.setMaximumFractionDigits(2);
		decimalFormat.setRoundingMode(RoundingMode.HALF_EVEN);
		System.out.println(decimalFormat.format(d));
	}
	
	
	/**
	 * 将字符串替换
	 @param from	需替换的字符串
	 @param to		替换成什么字符串
	 @param source	源字符串
	 @return		新的字符串
	 */
	private static String replace(String from, String to,String source) {
		StringBuffer bf= new StringBuffer("");
	    StringTokenizer st = new StringTokenizer(source,from,true);
	    while (st.hasMoreTokens()) {
	      String tmp = st.nextToken();
	      if(tmp.equals(from)) {
	        bf.append(to);
	      } else {
	        bf.append(tmp);
	      }
	    }
	    return bf.toString();
	}

	/**
	 * 把字符串反转
	 @param string	需反转的字符串
	 @return	反转后的字符串
	 */
	private static String reverse(String string) {
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = string.length()-1; i >=0 ; i--) {
			stringBuffer.append(string.charAt(i));
		}
		return stringBuffer.toString();
	}

}
