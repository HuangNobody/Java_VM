/*
 * �����嵥10-7�� �Զ�װ�䡢���������ѭ������֮��
 */
package cn.chapter10;


import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Solution10_7 {

	public static void main(String[] args) {

		List list = Arrays.asList(new Integer[]{
				Integer.valueOf(1),//Integer.valueOf(1)�Զ�װ��
				Integer.valueOf(2),
				Integer.valueOf(3),
				Integer.valueOf(4)
		});
		
		int sum = 0;
		for(Iterator localIterator = list.iterator();localIterator.hasNext();){//����ѭ��
			//  (Integer) ����
			int i = ((Integer) localIterator.next()).intValue();//intValue()�Զ����� 
			sum += i;
		}
		System.out.println(sum);
	}
}
