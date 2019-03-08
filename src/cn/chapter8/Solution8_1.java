package cn.chapter8;

/*
 * 代码清单8-1，局部变量表Slot复用对垃圾收集的影响之一
 * VM Args: -verbose:gc
 */
public class Solution8_1 {
	public static void main(String[] args) {
		
		byte [] placeholder = new byte[64 *1024 *1024];
		System.gc();
	}

}
