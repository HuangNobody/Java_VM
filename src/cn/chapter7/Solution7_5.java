package cn.chapter7;

/*
 * <clinit>()方法执行顺序
 * 父类中定义的静态语句块要优先于子类的变量复制操作，字段B的值将是2而不是1
 * 书上的源代码有问题啊，在子类要用static修饰，不然报错
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
