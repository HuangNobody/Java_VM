/*
 * 代码清单9-1， 动态代理的简单示例。原始的逻辑是打印一句“hello world”，代理的逻辑是在 
 * 原始类的方法执行前打印一句“welcome”
 */
package cn.chapter9;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyTest {
	
	interface IHello{
		void sayHello();
	}
	
	static class Hello implements IHello{
		@Override
		public void sayHello(){
			System.out.println("hello world");
		}
	}
	
	static class DynamicProxy implements InvocationHandler{
		Object originallObj;
		
		Object bind(Object originalObj){
			this.originallObj = originalObj;
			return Proxy.newProxyInstance(originalObj.getClass().getClassLoader(), originalObj.getClass().getInterfaces(), this);
		}
		
		@Override
		public Object invoke(Object proxy, Method method, Object [] args)throws Throwable{
			System.out.println("welcome");
			return method.invoke(originallObj, args);
		}
	}
	
	public static void main(String[] args) {
		IHello hello = (IHello) new DynamicProxy().bind(new Hello());
		hello.sayHello();
		System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

	}
}
