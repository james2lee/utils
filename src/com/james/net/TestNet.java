package com.james.net;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.Permission;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TestNet {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		try {
			//根据地址创建URL
			URL url = new URL("http://news.sina.com.cn/c/2013-10-23/183328513580.shtml");
			//获取URLConnection
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			//打开连接
			connection.connect();
			//获取连接属性
			System.out.println("getConnectTimeout: "+connection.getConnectTimeout());
			System.out.println("getContentEncoding: "+connection.getContentEncoding());
			System.out.println("getContentLength: "+connection.getContentLength());
			System.out.println("getContentType: "+connection.getContentType());
			System.out.println("getDate: "+new Date(connection.getDate()));
			System.out.println("getExpiration: "+new Date(connection.getExpiration()));
			System.out.println("getIfModifiedSince: "+connection.getIfModifiedSince());
			System.out.println("getLastModified: "+new Date(connection.getLastModified()));
			System.out.println("getURL: "+connection.getURL());
			Permission permission = connection.getPermission();
			System.out.println("permission.getName:  "+permission.getName());
			System.out.println("permission.getActions:  "+permission.getActions());
			
			System.out.println("");
			
			System.err.println("-HttpURLConnection专属方法-------------------------");
			System.out.println("getRequestMethod: "+connection.getRequestMethod());
			System.out.println("getResponseCode: "+connection.getResponseCode());
			System.out.println("getResponseMessage: "+connection.getResponseMessage());
			
			System.out.println("");
			
			System.err.println("~connection.getHeaderFields()~~~~~~~~~~~~~~~~~~~~");
			
			Map<String, List<String>> map = connection.getHeaderFields();
			//根据Map取得value
			/*Collection<List<String>> values = map.values();
			for (List<String> list : values) {
				System.out.println(list);
			}*/
		
			//根据Map取得key & value
			Set<String> set = map.keySet();
			for (String string : set) {
				List<String> valueList = map.get(string);
				System.out.println(string+"-->"+valueList);
			}
			
			//根据Map取得key & value
			/*Set<String> set = map.keySet();
			Iterator<String> it = set.iterator();
			while (it.hasNext()) {
				String key = (String) it.next();
				List<String> value = map.get(key);
				System.out.println(key +" ==: "+value);
			}*/
			
			//根据Map取得key &value
			/*Set<Entry<String, List<String>>> set = map.entrySet();
			Iterator<Entry<String, List<String>>> iterator = set.iterator();
			while (iterator.hasNext()) {
				Map.Entry<String, List<String>> entry = (Map.Entry<String, List<String>>) iterator.next();
				String key = entry.getKey();
				List<String> value = entry.getValue();
				System.out.println(key+":"+value);
			}
			*/
			
			System.err.println("~connection.getRequestProperties()~~~~~~~~~~~~~~~~~~~~");
			Map<String, List<String>> mapProp = connection.getRequestProperties();
			Set<String> keySet = mapProp.keySet();
			for (String string : keySet) {
				System.out.println(string+"<--"+mapProp.get(string));
			}
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
