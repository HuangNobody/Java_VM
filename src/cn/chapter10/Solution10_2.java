/*
 * 代码清单10-2， 泛型擦除前的例子
 */
package cn.chapter10;

import java.util.HashMap;
import java.util.Map;

public class Solution10_2 {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("hello", "你好");
		map.put("how are you?", "吃了没？");
		System.out.println(map.get("hello"));
		System.out.println(map.get("how are you?"));
	}
}
