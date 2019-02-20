/**
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15 -XX:+PrintTenuringDistribution -XX:+PrintGCDetails
 */
package cn.chapter3;

public class LongSurvivor2 {
	
	private static final int _1MB = 1024*1024;
	
	@SuppressWarnings("unused")
	public static void testTenuringThreshold2(){
		byte[] allocation1, allocation2, allocation3,allocation4;
		allocation1 = new byte[_1MB/4]; //allocation1 + allocation2大于survivor空间的一半
		allocation2 = new byte[_1MB/4];
		allocation3 = new byte[4*_1MB];
		allocation4 = new byte[4*_1MB];
		allocation4 = null;
		allocation4 = new byte[4*_1MB];
	}
	
	public static void main(String[] args) {
		testTenuringThreshold2();
	}
}
