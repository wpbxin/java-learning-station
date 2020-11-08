package cn.wpbxin.javabasis.operators;

/**
 * 关系运算符 == 和 equals 的区别的示例
 * @author wpbxin
 * @since 2020-11-01
 */
public class RelationalOperatorsVsEquals {
	public static void main(String[] args) {
		Integer int1 = -128;
		Integer int2 = -128;
		// 实际上 int1 和 int2 都是 Integer 缓冲池[-128,127] 中的同一个缓存对象
		System.out.println("int1 == int2 : " + (int1 == int2));
		System.out.println("int1.equals(int2) : " + (int1.equals(int2)));
		
		Integer int3 = 128;
		Integer int4 = 128;
		// 此时的 int3 和 int4 指向的2个完全不同的对象，但是内部数值其实是等价的
		System.out.println("int3 == int4 : " + (int3 == int4));
		System.out.println("int3.equals(int4) : " + (int3.equals(int4)));
		
		String str1 = "ZhangSan";
		String str2 = "ZhangSan";
		// 实际上 str1 和 str2 都是指向常量池上的 "ZhangSan"
		System.out.println("str1 == str2 : " + (str1 == str2));
		System.out.println("str1.equals(str2) : " + (str1.equals(str2)));
		
		String str3 = new String("ZhangSan");
		String str4 = new String("ZhangSan");
		// 此时的 str3 和 str4 指向的不同的堆对象 "ZhangSan"
		System.out.println("str3 == str4 : " + (str3 == str4));
		System.out.println("str3.equals(str4) : " + (str3.equals(str4)));
		System.out.println("str1 == str3 : " + (str1 == str3));
		System.out.println("str1.equals(str3) : " + (str1.equals(str3)));
	}
}
