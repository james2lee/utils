/**
 * N个数的排列
 */
package com.james.pernutation;

import java.util.ArrayList;


public class Permutation {
	public static int count = 0;

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("a");
		list.add("a");
		list.add("b");
		list.add("d");
		list.add("e");
		System.out.println("Before: "+list);
		ArrayList<String> newList = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			String s = list.get(i);
			if (!newList.contains(s)) {
				newList.add(s);
			}
		}
		System.out.println("After:(New) "+newList);
		/*
		int[] array = new int[] { 1, 2, 3, 4, 5, 6 };
		int n = 4;
		System.out.println("排列结果 : ");
		permutation(array, n);
		System.out.println("组合结果 : ");
		combination(array, n);*/
	}

	
	/**对数组进行排列
	 * 
	 * @param ia	需排列的所有数字组成的数组
	 * @param n		排列的位数
	 */
	public static void permutation(int[] ia, int n) {
		permutation("", ia, n);
	}

	public static void permutation(String s, int[] ia, int n) {
		if (n == 1) {
			for (int i = 0; i < ia.length; i++) {
				System.out.println(s + ia[i]);
			}
		} else {
			for (int i = 0; i < ia.length; i++) {
				String ss = "";
				ss = s + ia[i] + ", ";
				//建立没有第i个元素的子数组
				int[] ii = new int[ia.length - 1];
				int index = 0;
				for (int j = 0; j < ia.length; j++) {
					if (j != i) {
						ii[index++] = ia[j];
					}
				}
				permutation(ss, ii, n - 1);
			}
		}
	}
	
	
	/**对数组进行组合
	 * 
	 * @param ia	需组合的所有数字组成的数组
	 * @param n		排列的位数
	 */
	public static void combination(int[] ia, int n) {
		combination("", ia, n);
	}

	public static void combination(String s, int[] ia, int n) {
		if (n == 1) {
			for (int i = 0; i < ia.length; i++) {
				System.out.println(s + ia[i]);
			}
		} else {
			for (int i = 0; i < ia.length - (n - 1); i++) {
				String ss = "";
				ss = s + ia[i] + ", ";
				//建立从i开始的子数组
				int[] ii = new int[ia.length - i - 1];
				for (int j = 0; j < ia.length - i - 1; j++) {
					ii[j] = ia[i + j + 1];
				}

				combination(ss, ii, n - 1);
			}
		}
	}
}
