/**
 * 数组排序
 */
package com.james.utils;

public class SortArray {

	public static void main(final String args[]) {
		String[] arrayStrings = { "j", "e", "k", "h", "3", "1", "9" };
		for (String string : arrayStrings) {
			System.out.print(string + ",");
		}
		// bubbleSort(arrayStrings);
		// selectSort(arrayStrings);
		// insertSort(arrayStrings);
		// shellSort(arrayStrings);
		quickSort(arrayStrings, 0, arrayStrings.length - 1);
		System.out.println("");
		for (String string : arrayStrings) {
			System.out.print(string + ",");
		}
	}
	/**
	 * 快速排序算法
	 * @param data 数组
	 * @param low  一般为0	
	 * @param high	一般为数组的长度-1
	 */

	public static void quickSort(Comparable<String>[] data, int low, int high) {
		// 枢纽元，一般以第一个元素为基准进行划分
		int i = low;
		int j = high;
		if (low < high) {
			// 从数组两端交替地向中间扫描
			Comparable<String> pivotKey = data[low];
			// 进行扫描的指针i,j;i从左边开始，j从右边开始
			while (i < j) {
				while (i < j && data[j].compareTo((String) pivotKey) > 0) {
					j--;
				}// end while
				if (i < j) {
					// 比枢纽元素小的移动到左边
					data[i] = data[j];
					i++;
				}// end if
				while (i < j && data[i].compareTo((String) pivotKey) < 0) {
					i++;
				}// end while
				if (i < j) {
					// 比枢纽元素大的移动到右边
					data[j] = data[i];
					j--;
				}// end if
			}// end while
				// 枢纽元素移动到正确位置
			data[i] = pivotKey;
			// 前半个子表递归排序
			quickSort(data, low, i - 1);
			// 后半个子表递归排序
			quickSort(data, i + 1, high);
		}// end if
	}// end sort

	/**
	 * 希尔排序 希尔排序(Shell Sort)是插入排序的一种。是针对直接插入排序算法的改进。该方法又称缩小增量排序
	 * 
	 * @param arrayStrings
	 */
	public static void shellSort(String[] arrayStrings) {
		System.out.println("  ");
		System.out.println("希尔排序！");
		String temp;
		for (int i = arrayStrings.length / 2; i > 0; i /= 2) {
			for (int j = i; j < arrayStrings.length; j++) {
				temp = arrayStrings[j];
				int k = 0;
				for (k = j; k >= i; k -= i) {
					if (temp.compareTo(arrayStrings[k - i]) < 0) {
						arrayStrings[k] = arrayStrings[k - i];
					} else {
						break;
					}
				}
				arrayStrings[k] = temp;
			}
		}
	}

	/**
	 * 冒泡排序 原理：从最后一个开始将小的或大的逐渐冒出
	 * 
	 * @param arrayStrings
	 */
	public static void bubbleSort(String[] arrayStrings) {
		String temp;
		for (int j = 0; j < arrayStrings.length - 1; j++) {
			for (int i = j + 1; i < arrayStrings.length; i++) {
				if (arrayStrings[j].compareTo(arrayStrings[i]) > 0) {
					temp = arrayStrings[i];
					arrayStrings[i] = arrayStrings[j];
					arrayStrings[j] = temp;
				}
			}
		}
	}

	/**
	 * 选择排序 排序原理：每次选择一个最大的或最小的数放到已排序序列中
	 * 
	 * @param arrayString
	 */
	public static void selectSort(String[] arrayString) {
		String temp;
		for (int i = 0; i < arrayString.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < arrayString.length; j++) {
				if (arrayString[min].compareTo(arrayString[j]) < 0) {
					min = j;
				}
			}
			if (min != i) {
				temp = arrayString[i];
				arrayString[i] = arrayString[min];
				arrayString[min] = temp;
			}
		}
	}

	/**
	 * 插入排序 排序原理：抽出一个数，做为排序基序列，然后依次抽出其它数与，与此序列中的数进行比较，放入合适的位置
	 * 
	 * @param arrStrings
	 */
	public static void insertSort(String[] arrStrings) {
		String temp;
		for (int i = 0; i < arrStrings.length; i++) {
			for (int j = i; j > 0; j--) {
				if (arrStrings[j].compareTo(arrStrings[j - 1]) > 0) {
					temp = arrStrings[j - 1];
					arrStrings[j - 1] = arrStrings[j];
					arrStrings[j] = temp;
				}
			}
		}
	}
}