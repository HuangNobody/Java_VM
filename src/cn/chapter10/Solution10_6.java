/*
 * 代码清单10-6， 自动装箱、拆箱与遍历循环
 */
package cn.chapter10;

import java.util.Arrays;
import java.util.List;

public class Solution10_6 {
	
	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(1,2,3,4);
		//能让上面这句代码进一步简写撑List<Integer> list = [1,2,3,4];
		int sum = 0;
		for(int i : list){
			sum += i;
		}
		System.out.println(sum);
	}
}
