package cn.wpbxin.collectionsframework.iteration;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Consumer;

/**
 * List 的几种迭代方式
 * 
 * @author wpbxin
 * @since 2020-09-21
 */
public class ListIteration {
	public static void main(String[] args) {
		List<String> strList = new ArrayList<>();
		/// List<String> strList = new LinkedList<>();
		strList.add("1st");
		strList.add("2nd");
		strList.add("3rd");
		strList.add("4th");

		// 1、 索引下标 for 循环
		// 注意：对于链表形式的实现，每次都是 O(N),总的是(O(N*N))，效率较低
		System.out.println("for 循环");
		for (int i = 0, length = strList.size(); i < length; i++) {
			System.out.println(strList.get(i));
		}

		// 2、 增强的 for 循环,内部是迭代器实现
		// https://docs.oracle.com/javase/specs/jls/se8/html/jls-14.html#jls-14.14.2
		System.out.println("增强的 for 循环");
		for (String str : strList) {
			System.out.println(str);
		}

		// 3.1、 Iterator 迭代器 while 形式
		System.out.println("Iterator 迭代器 while 形式");
		Iterator<String> itr = strList.iterator();
		while (itr.hasNext()) {
			String string = itr.next();
			System.out.println(string);
		}
		// 3.2、 Iterator 迭代器 for 形式
		System.out.println("Iterator 迭代器 for 形式");
		for (Iterator<String> iterator = strList.iterator(); iterator.hasNext();) {
			String string = iterator.next();
			System.out.println(string);
		}

		// 4、 ListIterator 双向迭代器, Iterator 的子类型, List 集合特有的方式
		// ListIterator 双向, 还可以进行 add、remove、set、定位当前索引
		// ArrayList 和 LinkedList 各自的内部类实现
		ListIterator<String> listItr = strList.listIterator();
		System.out.println("ListIterator 反向迭代1");
		// 这里并没有上一个，所以没有
		while (listItr.hasPrevious()) {
			String string = listItr.previous();
			System.out.println(string);
		}
		System.out.println("ListIterator 正向迭代");
		while (listItr.hasNext()) {
			String string = listItr.next();
			System.out.println(string);
		}
		System.out.println("ListIterator 反向迭代2");
		while (listItr.hasPrevious()) {
			String string = listItr.previous();
			System.out.println(string);
		}

		// 5、 Java 8 Lambda 迭代方式
		// 本质上还是增强的 for 循环(内部是迭代器实现),将对应的操作封装到 Consumer 里面
		System.out.println("Java 8 Lambda 迭代方式");
		strList.forEach(str -> System.out.println(str));
		System.out.println("=-=");
		strList.forEach(System.out::println);
		strList.forEach(str -> {
			System.out.println("---");
			System.out.println(str);
		});
		// 比较完整的写法，其实就是自定义 Consumer 接口的实现类，重写 accept 方法
		strList.forEach(new Consumer<String>() {
			@Override
			public void accept(String str) {
				System.out.println("-=-");
				System.out.println(str);
			};
		});

		// 6、 Java 8 Stream 迭代方式
		System.out.println("Java 8 Stream 迭代方式");
		strList.stream().forEach(System.out::println);
		System.out.println("-~-");
		strList.stream().forEach(str -> System.out.println(str));
		strList.stream().forEach(str -> {
			System.out.println("===");
			System.out.println(str);
		});
		// 也可以使用自定义 Consumer 接口的实现类的方式
	}
}
