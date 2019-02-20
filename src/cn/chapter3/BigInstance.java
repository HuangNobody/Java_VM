/**
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -verbose:gc -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728
 * 3145728B表示3M，但是不能写成3M
 * @author huangh
 */
package cn.chapter3;

public class BigInstance {
	
	private static final int _1MB = 1024*1024;
	
	public static void testPretenureSizeThreshold(){
		byte[] allocation;
		allocation = new byte[4 * _1MB];//直接分配在老年代中
	}
	
	public static void main(String[] args) {
		testPretenureSizeThreshold();
	}
}
