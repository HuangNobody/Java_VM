/*
 * �����嵥10-6�� �Զ�װ�䡢���������ѭ��
 */
package cn.chapter10;

import java.util.Arrays;
import java.util.List;

public class Solution10_6 {
	
	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(1,2,3,4);
		//���������������һ����д��List<Integer> list = [1,2,3,4];
		int sum = 0;
		for(int i : list){
			sum += i;
		}
		System.out.println(sum);
	}
}
