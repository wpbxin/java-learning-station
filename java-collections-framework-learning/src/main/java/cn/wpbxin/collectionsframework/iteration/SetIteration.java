package cn.wpbxin.collectionsframework.iteration;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Set 的几种迭代方式
 * 
 * @author wpbxin
 * @since 2020-09-21
 */
public class SetIteration {
	public static void main(String[] args) {
		Set<String> strSet = new HashSet<>();
		// Set<String> strSet = new LinkedHashSet<>();
		// Set<String> strSet = new TreeSet<>();
		strSet.add("1st");
		strSet.add("2nd");
		strSet.add("3rd");
		strSet.add("4th");

		// 1、 增强的 for 循环
		System.out.println("增强的 for 循环");
		for (String str : strSet) {
			System.out.println(str);
		}

		// 2.1、 Iterator 迭代器 while 形式
		System.out.println("Iterator 迭代器 while 形式");
		Iterator<String> itr = strSet.iterator();
		while (itr.hasNext()) {
			String string = itr.next();
			System.out.println(string);
		}
		// 2.2、 Iterator 迭代器 for 形式
		System.out.println("Iterator 迭代器 for 形式");
		for (Iterator<String> iterator = strSet.iterator(); iterator.hasNext();) {
			String string = iterator.next();
			System.out.println(string);
		}

		// 3、 Java 8 Lambda 迭代方式
		// 本质上还是增强的 for 循环(内部是迭代器实现),将对应的操作封装到 Consumer 里面
		System.out.println("Java 8 Lambda 迭代方式");
		strSet.forEach(str -> System.out.println(str));

		// 4、 Java 8 Stream 迭代方式
		System.out.println("Java 8 Stream 迭代方式");
		strSet.stream().forEach(System.out::println);
		System.out.println("-~-");
		strSet.stream().forEach(str -> System.out.println(str));
	}
}
