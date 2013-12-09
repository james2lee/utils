package com.james.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "a");
		map.put(2, "b");
		map.put(3, "c");
		map.put(4, "d");
		map.put(5, "e");

//		 mapTest1(map);
		mapTest2(map);
//		mapTest3(map);
		 System.out.println(map.containsKey(6));
	}

	/**
	 * 取得Value
	 * @param map
	 */
	public static void mapTest1(Map<Integer, String> map) {
		Iterator<String> it = map.values().iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

	/**
	 * 取得Key:Value
	 * @param map
	 */
	public static void mapTest2(Map<Integer, String> map) {
		Iterator<Integer> iterator = map.keySet().iterator();
		for (; iterator.hasNext();) {
			Integer key = (Integer) iterator.next();
			System.out.println(key + "==" + map.get(key));
		}

		/*while (iterator.hasNext()) {
			Integer key = (Integer) iterator.next();
			String value = map.get(key);
			System.out.println(key + "==" + value);
		}*/
	}
	
	/**
	 * 取得Key:Value
	 * @param map
	 */
	public static void  mapTest3(Map<Integer, String> map) {
		Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<Integer, String> entry = (Map.Entry<Integer, String>) iterator.next();
			System.out.println(entry.getKey()+"-->"+entry.getValue());
		}
	}
}
