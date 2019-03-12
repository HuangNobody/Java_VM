/*
 * 代码清单11-2，测试代码
 * VM Args:-XX:+PrintCompilation 
 * VM Args:-XX:+PrintInlining
 */
package cn.chapter11;

public class Solution11_2 {
	
	public static final int NUM 
	
	= 15000;

	public static int doubleValue(int i){
		return i*2;
	}
	
	public static long calcSum(){
		long sum = 0;
		for(int i =1;i<=100;i++)
			sum += doubleValue(i);
		return sum;
	}
	
	public static void main(String[] args) {
		for(int i = 0;i<NUM;i++)
			calcSum();
	}
}
