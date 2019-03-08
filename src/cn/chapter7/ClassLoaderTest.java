package cn.chapter7;

import java.io.IOException;
import java.io.InputStream;
import java.lang.ClassLoader;

/*
 *�����嵥7-7�� ��ͬ�����������instanceof�ؼ�����������Ӱ�졣 
 */

public class ClassLoaderTest {

	public static void main(String [] args) throws Exception{
		ClassLoader myLoader = new ClassLoader(){//���ClassLoaderҪimport java.lang.ClassLoader;
			@Override
			public Class<?> loadClass(String name) throws ClassNotFoundException{
				try{
					String fileName = name.substring(name.lastIndexOf(".")+1);
					InputStream is = getClass().getResourceAsStream(fileName);
					if(is == null){
						return super.loadClass(name);
					}
					byte [] b = new byte[is.available()];
					is.read(b);
					return defineClass(name, b, 0, b.length);
				}catch(IOException e){
					throw new ClassNotFoundException(name);
				}
			}
		};
		
		Object obj = myLoader.loadClass("cn.chapter7.ClassLoaderTest").newInstance();
		
		System.out.println(obj.getClass());
		System.out.println(obj instanceof cn.chapter7.ClassLoaderTest);
	}
}

