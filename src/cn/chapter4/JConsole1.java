/**
 *�����嵥4-6 JConsole���Ӵ���
 * �ڴ�ռλ������һ��OOMObject��Լռ64KB
 * VM Args��-verbose:gc -Xms100M -Xmx100M -XX:+UseSerialGC
 */
package cn.chapter4;

import java.util.ArrayList;
import java.util.List;

public class JConsole1 {
	
	static class OOMObject{
		public byte[] placeholder = new byte[64*1024];
	}
	
	public static void fillHeap(int num) throws InterruptedException{
		List<OOMObject> list = new ArrayList<OOMObject>();
		for(int i = 0;i<num;i++){
			//�����ӳ٣���������ߵı仯��������
			Thread.sleep(50);
			list.add(new OOMObject());
		}
		System.gc();
	}
	
	public static void main(String[] args) throws Exception{
		fillHeap(1000);
	}

}
