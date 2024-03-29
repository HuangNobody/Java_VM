/*
 * 代码清单13-3，必须加入同步以保证Vector访问线程安全性
 */
package cn.chapter13;

import java.util.Vector;

public class Solution13_3 {
	
	private static Vector<Integer> vector = new Vector<Integer>();
	
	public static void main(String[] args) {

		while(true){
			for(int i =0 ;i<10;i++){
				vector.add(i);
			}
			
			Thread removeThread = new Thread(new Runnable(){
				@Override
				public void run(){
					synchronized(vector){
						for(int i = 0;i<vector.size();i++){
							vector.remove(i);
						}
					}
				}
			});
			
			Thread printThread = new Thread(new Runnable(){
				@Override
				public void run(){
					synchronized(vector){
						for(int i = 0;i<vector.size();i++){
							System.out.println(vector.get(i));
						}
					}
				}
			});
			
			removeThread.start();
			printThread.start();
			
			//不要同时产生过多的线程，否则会导致操作系统假死
			while(Thread.activeCount()>10);
		}
	}
}
