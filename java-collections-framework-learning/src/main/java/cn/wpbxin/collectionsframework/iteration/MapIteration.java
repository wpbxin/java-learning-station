package cn.wpbxin.collectionsframework.iteration;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Map 的几种迭代方式
 * 
 * @author wpbxin
 * @since 2020-09-21
 */
public class MapIteration {
	public static void main(String[] args) {
		Map<String, String> strMap = new HashMap<>();
		// Map<String, String> strMap = new LinkedHashMap<>();
		// Map<String, String> strMap = new TreeMap<>();
		strMap.put("1", "1st");
		strMap.put("2", "2nd");
		strMap.put("3", "3rd");
		strMap.put("4", "4th");

		// 1、 Map.Entry + foreach 的迭代方式
		System.out.println("Map.Entry + foreach 迭代方式");
		for (Map.Entry<String, String> entry : strMap.entrySet()) {
			System.out.println(entry.getKey() + "=" + entry.getValue());
		}
		
		// 2.1、  Map.Entry + Iterator 的 while 迭代方式
		System.out.println("Map.Entry + Iterator 的 while 迭代方式");
		Iterator<Map.Entry<String, String>> mapItr = strMap.entrySet().iterator();
		while (mapItr.hasNext()) {
			Map.Entry<String, String> entry = mapItr.next();
			System.out.println(entry.getKey() + "=" + entry.getValue());
		}

		// 2.2、  Map.Entry + Iterator 的 for 迭代方式
		System.out.println("Map.Entry + Iterator 的 for 迭代方式");
		for (Iterator<Map.Entry<String, String>> mapItrs = strMap.entrySet().iterator(); mapItrs.hasNext();) {
			Map.Entry<String, String> entry = mapItrs.next();
			System.out.println(entry.getKey() + "=" + entry.getValue());
		}
		
		// 3、 keySet + foreach 的迭代方式
		System.out.println("keySet + foreach 的迭代方式");
		Set<String> keySet = strMap.keySet();
		for (String key : keySet) {
			System.out.println(key + "=" + strMap.get(key));
		}
		
		// 4、 keySet + Iterator 的迭代方式
		System.out.println("keySet + Iterator 的迭代方式");
		Iterator<String> strItr = strMap.keySet().iterator();
		while (strItr.hasNext()) {
			String key = strItr.next();
			System.out.println(key + "=" + strMap.get(key));
		}
		
		// 以下这些都可以通过自定义 Consumer 接口的实现类来处理
		// 5、 Iterable.forEach + Lambda (Java 8 Lambda 迭代方式)
		System.out.println("Iterable.forEach + Lambda (Java 8 Lambda 迭代方式)");
		strMap.forEach((k, v) -> System.out.println(k + "=" + v));
		
		// 6、 Stream.forEach ( Java 8 Stream 迭代方式)
		System.out.println("Stream.forEach ( Java 8 Stream 迭代方式)");
		strMap.entrySet().forEach((entry) -> System.out.println(entry.getKey() + "=" + entry.getValue()));
	}
}
