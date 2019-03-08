package cn.chapter7;

/*
 * <clinit>()����ִ��˳��
 * �����ж���ľ�̬����Ҫ����������ı������Ʋ������ֶ�B��ֵ����2������1
 * ���ϵ�Դ���������Ⱑ��������Ҫ��static���Σ���Ȼ����
 */

public class Solution7_5 {

	static class Parent{
		public static int A = 1;
		static{
			A = 2;
		}
	}
	
	public static class Sub extends Parent{
		public static   int B = A;
	}
	
	public static void main(String[] args) {
		System.out.println(Sub.B);

	}

}
