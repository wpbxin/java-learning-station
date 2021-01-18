package cn.wpbxin.javabasis.operators;

/**
 * 递增和递减运算符
 * @author wpbxin
 * @since 2020-11-09
 */
public class AutoIncrementandDecrementOperators {
	public static void main(String[] args) {
		int i = 0;
		int j = i++;
		System.out.println(j);	// 输出结果: 0
		i = 0;
		j = ++i;
		System.out.println(j);	// 输出结果: 1
		
		short k = -32768;
		k--;
		System.out.println(k);	// 输出结果: 32767
		// 结果上与此等价
		k = (short) -32769;
		System.out.println(k);	// 输出结果: 32767
	}
}
