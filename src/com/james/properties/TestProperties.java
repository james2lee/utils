package com.james.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;

public class TestProperties {
	public static void main(String[] args) {
		try {
			Properties properties = new Properties();
			FileInputStream fis = new FileInputStream("xml/project.properties");
			//读取Properties文件
			properties.load(fis);
			
			//获取Key列表
			Iterator<Object> keys = properties.keySet().iterator();
			while (keys.hasNext()) {
				String key = (String) keys.next();
				//根据Key获取值
				String value = properties.getProperty(key);
				System.out.println(key+" =: "+value);
			}
			fis.close();
			
			//将读取的内容写入文件
			FileOutputStream fos = new FileOutputStream("D:/aaa.properties");
			properties.store(fos, "aaaaaaaaaaaa");
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
