/*
 * 10-3, ���Ͳ����������
 */
package cn.chapter10;

import java.util.HashMap;
import java.util.Map;

public class Solution10_3 {

	public static void main(String[] args) {
		Map map = new HashMap();
		map.put("hello", "���");
		map.put("how are you?", "����û��");
		System.out.println((String)map.get("hello"));//�������¼Ӳ���(String)���û��Ӱ�죬����Ϊʲô�ӣ�����
		System.out.println((String)map.get("how are you?"));
	}
}
