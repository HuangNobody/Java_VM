/*
 * 代码清单10-7， 自动装箱、拆箱与遍历循环编译之后
 */
package cn.chapter10;


import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Solution10_7 {

	public static void main(String[] args) {

		List list = Arrays.asList(new Integer[]{
				Integer.valueOf(1),//Integer.valueOf(1)自动装箱
				Integer.valueOf(2),
				Integer.valueOf(3),
				Integer.valueOf(4)
		});
		
		int sum = 0;
		for(Iterator localIterator = list.iterator();localIterator.hasNext();){//遍历循环
			//  (Integer) 泛型
			int i = ((Integer) localIterator.next()).intValue();//intValue()自动拆箱 
			sum += i;
		}
		System.out.println(sum);
	}
}
