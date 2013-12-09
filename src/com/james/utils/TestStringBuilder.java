package com.james.utils;

public class TestStringBuilder {
	public static void main(String[] args) {
		String constString = "A";
		long startTime = System.currentTimeMillis();
		for(int i =0 ; i<=10000;i++){
			constString+=i;
		}
		System.out.println(constString.toString());
		System.out.println("Const String: "+(System.currentTimeMillis()-startTime));
		
		StringBuffer stringBuffer = new StringBuffer("A");
		startTime = System.currentTimeMillis();
		for(int i =0 ; i<=10000;i++){
			stringBuffer.append(i);
		}
		System.out.println(stringBuffer.toString());
		System.out.println("StringBuffer: "+(System.currentTimeMillis()-startTime));
		
		StringBuilder stringBuilder = new StringBuilder("A");
		startTime = System.currentTimeMillis();
		for(int i =0 ; i<=10000;i++){
			stringBuilder.append(i);
		}
		System.out.println(stringBuilder.toString());
		System.out.println("stringBuilder: "+(System.currentTimeMillis()-startTime));
	}
}
