package cn.chapter7;

/*
 * 代码清单7-6， 字段解析
 */

public class Solution7_6 {

	static class DeadLoopClass{
		static{
			//如果不加上这个if语句，编译器将提示“Initializer does not complete normally”并拒绝执行
			if(true){
				System.out.println(Thread.currentThread()+"init DeadLoopClass");
				while(true){
					
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Runnable script = new Runnable(){
			public void run(){
				System.out.println(Thread.currentThread()+"start");
				DeadLoopClass dlc = new DeadLoopClass();
				System.out.println(Thread.currentThread()+"run over");
			}
		};
		
		Thread thread1 = new Thread(script);
		Thread thread2 = new Thread(script);
		thread1.start();
		thread2.start();
	}
}
