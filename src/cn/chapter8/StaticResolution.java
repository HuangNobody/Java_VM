/*
 * 代码清单8-5， 方法静态解析演示
 * @author:huang
 */

package cn.chapter8;

public class StaticResolution {
	
	public static void sayHello(){
		System.out.println("hello world");
	}

	public static void main(String[] args) {
		
		StaticResolution.sayHello();

	}
}
