package com.james.array;

public class ReverseArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer [] intArray = new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		Reverse(intArray);
		for (Integer integer : intArray) {
			System.out.print(integer+" ");
		}
	}

	private static void Reverse(Integer[] intArray) {
	/*	int left = 0;
		int right = intArray.length-1;
		while (left < right) {
			Integer temp = intArray[left];
			intArray[left] = intArray[right];
			intArray[right] = temp;
			left++;
			right--;
		}*/
		
	/*	int len = intArray.length-1;
		for (int i = 0; i <= len/2; i++) {
			int temp = intArray[i];
			intArray[i] = intArray[len-i];
			intArray[len-i] = temp;
		}*/
		
		for (int i = 0,j=intArray.length-1;i<j; i++,j--) {
			int temp = intArray[i];
			intArray[i] = intArray[j];
			intArray[j] = temp;
		}
	}
}
