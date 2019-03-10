/*
 * �����嵥9-3�� HotSwapClassLoader��ʵ��
 * Ϊ�˶������ִ���������ļ�����<br>
 * ��defineClass�������ų�����ֻ���ⲿ��ʾ���õ���ż�Ż�ʹ�õ�loadByte����
 * �����������ʱ����Ȼ����ԭ�е�˫��ί�ɹ���ʹ��loadClass�������������
 */
package cn.chapter9;

public class HotSwapClassLoader extends ClassLoader{

	public  HotSwapClassLoader(){
		super( HotSwapClassLoader.class.getClassLoader());
	}
	
	public Class loadByte(byte [] classByte){
		return defineClass(null, classByte, 0,classByte.length);
	}
}
