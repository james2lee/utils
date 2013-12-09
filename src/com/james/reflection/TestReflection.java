package com.james.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestReflection {
	public static void main(String[] args) {
		try {
			Class clazz = Class.forName("java.lang.String");
			Field[] methods = clazz.getDeclaredFields();
			for (int i = 0; i < methods.length; i++) {
				System.out.println(methods[i].toString());
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
