/*
 * �����嵥10-2�� ���Ͳ���ǰ������
 */
package cn.chapter10;

import java.util.HashMap;
import java.util.Map;

public class Solution10_2 {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("hello", "���");
		map.put("how are you?", "����û��");
		System.out.println(map.get("hello"));
		System.out.println(map.get("how are you?"));
	}
}
