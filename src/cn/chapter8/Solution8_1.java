package cn.chapter8;

/*
 * �����嵥8-1���ֲ�������Slot���ö������ռ���Ӱ��֮һ
 * VM Args: -verbose:gc
 */
public class Solution8_1 {
	public static void main(String[] args) {
		
		byte [] placeholder = new byte[64 *1024 *1024];
		System.gc();
	}

}
