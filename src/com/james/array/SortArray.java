package com.james.array;

public class SortArray {
	public static Integer getMiddle(String[] list, int left, int right) {  
        String tmp = list[left];    //����ĵ�һ����Ϊ����  
        while (left < right) {  
            while (left < right && list[right].compareTo(tmp)<0) {  
                right--;  
            }  
            list[left] = list[right];   //������С�ļ�¼�Ƶ��Ͷ�  
            while (left < right && list[left].compareTo(tmp)>0) {  
                left++;  
            }  
            list[right] = list[left];   //�������ļ�¼�Ƶ��߶�  
        }  
        list[left] = tmp;              //�����¼��β  
        return left;
    }  
	
	public static void _quickSort(String[] list, int left, int right) {  
        if (left < right) {  
            Integer middle = getMiddle(list, left, right);  //��list�������һ��Ϊ��  
            _quickSort(list, left, middle - 1);        //�Ե��ֱ���еݹ�����  
            _quickSort(list, middle + 1, right);       //�Ը��ֱ���еݹ�����  
        }  
    } 

	public static void main(String[] args) {
		String[] strVoid = new String[] { "11", "77", "33",  "55", "22", "0", "32" };
		//quickSort(strVoid, 0, strVoid.length - 1);
		_quickSort(strVoid, 0, strVoid.length - 1);
		for (int i = 0; i < strVoid.length; i++) {
			System.out.println(strVoid[i] + " ");
		}
	}

}
