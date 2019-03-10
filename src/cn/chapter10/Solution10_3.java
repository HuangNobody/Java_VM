/*
 * 10-3, 泛型擦除后的例子
 */
package cn.chapter10;

import java.util.HashMap;
import java.util.Map;

public class Solution10_3 {

	public static void main(String[] args) {
		Map map = new HashMap();
		map.put("hello", "你好");
		map.put("how are you?", "吃了没？");
		System.out.println((String)map.get("hello"));//我试了下加不加(String)输出没有影响，书上为什么加？？？
		System.out.println((String)map.get("how are you?"));
	}
}
