package com.james.pernutation;

import java.util.HashMap;
import java.util.Map;

public class Main {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		Main m = new Main();
		ClassA a = m.new ClassA();
		System.out.println(a.size());
		System.out.println(a.get("a"));
		System.out.println(a.containsKey("g"));
		Map<String , String> map = a.getValues();
		System.out.println(map);
	}
	
	private class ClassA{
		private  HashMap<String, String> values = new HashMap<String, String>();
		
		public ClassA() {
			values.put("a", "a1");
			values.put("b", "b1");
			values.put("c", "c1");
			values.put("d", "d1");
			values.put("e", "e1");
		}

		public String get(String key) {
			return values.get(key);
		}
		
		public boolean containsKey(String key) {
			return values.containsKey(key);
		}
		
		public int size() {
			return values.size();
		}
		
		public Map<String, String> getValues(){
			return values;
		}
	}

}
