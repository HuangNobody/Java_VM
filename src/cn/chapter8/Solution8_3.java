package cn.chapter8;

/*
 * 代码清单8-3.局部变量表Slot复用丢垃圾收集的影响之一
 * VM Args: -verbose:gc
 */

public class Solution8_3 {

	public static void main(String[] args) {
		{
			byte [] placeholder = new byte[64* 1024*1024];
		}
		int a = 0;
		System.gc();

	}

}
