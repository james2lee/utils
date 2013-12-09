package com.james.utils;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class System_getProp_getenv {

	public static void main(String[] args) {
		testGetEnv();
		System.out.println("=======================================================");
		testGetProperties();
	}

	/**
	 * test System.getProperties()
	 */
	private static void testGetProperties() {
		Properties properties = System.getProperties();
		@SuppressWarnings("unchecked")
		Enumeration<String> enu = (Enumeration<String>) properties.propertyNames();
		while (enu.hasMoreElements()) {
			String name = (String) enu.nextElement();
			System.out.println(name+" = "+properties.getProperty(name));
		}
		/*Set<Entry<Object, Object>> set1 = properties.entrySet();
		for (Object object : set1) {
			System.out.println(object);
		}*/
	}

	/**
	 * test System.getenv()
	 */
	private static void testGetEnv() {
		Map<String, String> map = System.getenv();
		Set<String> set = map.keySet();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String name = it.next();
			System.out.println(name+" = "+map.get(name));
		}
	}
}
