/**
 * testGC()����ִ�к�objA��objB�᲻�ᱻGC�أ�
 *VM Args:-verbose:gc: -Xms20M -Xmx20M -Xmn10M -verbose:gc -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * @author huangh
 */
package cn.chapter3;

public class ReferenceCountingGC {
	
	public Object instance = null;
	
	private static final int _1MB = 1024*1024;
	
	/**
	 * �����Ա��Ψһ�������ռ���ڴ棬�Ա�����GC��־�п�����Ƿ񱻻��չ�
	 */
	
	private byte[] bigSize = new byte[2*_1MB];
	
	public static void testGC(){
		ReferenceCountingGC objA = new ReferenceCountingGC();
		ReferenceCountingGC objB = new ReferenceCountingGC();
		objA.instance = objB;
		objB.instance = objA;
		
		objA = null;
		objB = null;
		
		//���������з���GC����ôobjA��objB�Ƿ��ܱ����գ�
		System.gc();
	}
	
	public static void main(String[] args){
		testGC();
	}
}
