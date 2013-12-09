package com.james.utils;

import java.math.BigInteger;

/**
 * 计算阶乘
 * 
 * @author James
 * 
 */
public class Factorial {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Long start = System.currentTimeMillis();

		BigInteger resultBigInteger = loop(10000);
		//BigInteger resultBigInteger = addArray(10000);
		// BigInteger resultBigInteger = recursion(1000);

		Long end = System.currentTimeMillis();
		System.out.println("Time: " + (end - start));
		System.out.println("Result: " + resultBigInteger);
		System.out.println("Length: " + resultBigInteger.toString().length());
	}

	// 方式一:循环
	public static BigInteger loop(int num) {
		if (num < 0) {
			throw new IllegalArgumentException("必须为正整数!");
		}
		BigInteger result = new BigInteger("1");
		for (int i = 1; i <= num; i++) {
			BigInteger num1 = new BigInteger(String.valueOf(i));
			result = result.multiply(num1);
		}
		return result;
	}

	// 方式二:递归
	public static BigInteger recursion(int num) {
		BigInteger result = new BigInteger("1");
		if (num < 0) {
			throw new IllegalArgumentException("必须为正整数!");
		}
		if (num == 1) {
			return result;
		} else {
			result = new BigInteger(String.valueOf(num)).multiply(recursion(num - 1));
		}
		return result;
	}

	// 方式三:数组

	public static BigInteger addArray(int num) {// 数组添加计算阶乘
		BigInteger[] arr = new BigInteger[10000000];// 创建数组
		arr[0] = new BigInteger("1");
		int last = 0;
		if (num >= arr.length) {
			throw new IllegalArgumentException("传入的值太大");// 抛出传入的数太大异常
		}
		if (num < 0)
			throw new IllegalArgumentException("必须为正整数!");// 抛出不合理参数异常
		while (last < num) {// 建立满足小于传入数的while循环
			arr[last + 1] = arr[last].multiply(new BigInteger(String.valueOf(last+1)));// 进行运算
			last++;// last先进行运算，再将last的值加1
		}
		return arr[num];
	}

}
