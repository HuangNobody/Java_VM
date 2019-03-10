/*
 * 代码清单10-4， 当泛型遇见重载1
 */
package cn.chapter10;

import java.util.List;

public class GenericTypes {

	public static void method(List<String> list){
		System.out.println("invoke method(List<String>)");
	}
	
//	public static void method(List<Integer> list){
//		System.out.println("invoke method(List<Integer> list)");
//	}
}
