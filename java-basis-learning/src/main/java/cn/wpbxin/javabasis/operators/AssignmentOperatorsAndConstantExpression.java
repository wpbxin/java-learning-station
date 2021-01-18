package cn.wpbxin.javabasis.operators;

/**
 * 复合赋值运算符+=, -=, *=, /= 和 常量表达式的相关案例
 * @author wpbxin
 * @since 2020-11-08
 */
public class AssignmentOperatorsAndConstantExpression {
	public static void main(String[] args) {
		// 注:short ∈ [-32768, 32767]
		{
			/*
			 * 1、对于 +=, -=, *=, /=, Java编译器默认会添加强制类型转换，
			 * 即 T a; X b; a += b; 等价于 T a; X b; a = (T) (a + b);
			 */

			// 0是int类型的常量，且在short范围内，被Java编译器默认强制转换的
			short i = 0;
			// 等价于 i = (short) (i + 1);
			i += 1;
			System.out.println("[xin01] i=" + i); // 输出结果: 1
			i = (short) (i + 1);
			System.out.println("[xin02] i=" + i); // 输出结果: 2
			/*
			 * 下面这2行都会有编译报错提示：
			 * Exception in thread "main" java.lang.Error: Unresolved compilation problem:
			 *     Type mismatch: cannot convert from int to short
			 * [注]错误: 不兼容的类型: 从int转换到short可能会有损失
			 * Eclipse 也会有提示： Type mismatch: cannot convert from int to short
			 */
			// i = i + 1;
			// i = 32768;

			i = 0;
			// 等价于 i = (short) (i + 32768); 下同
			i += 32768;
			System.out.println("[xin03] i=" + i); // 输出结果: -32768
			i += -32768;
			System.out.println("[xin04] i=" + i); // 输出结果: 0

			i = 0;
			long j = 32768;
			i += j;
			System.out.println("[xin05] i=" + i); // 输出结果: -32768

			i = 0;
			float f = 1.23F;
			i += f;
			System.out.println("[xin06] i=" + i); // (小数位截断)输出结果: 1

			i = 0;
			double d = 4.56D;
			i += d;
			System.out.println("[xin07] i=" + i); // (小数位截断)输出结果: 4
			
			i = 10;
			i *= 3.14D;
			System.out.println("[xin08] i=" + i); // 输出结果: 31
			
			i = 100;
			i /= 2.5D;
			System.out.println("[xin09] i=" + i); // 输出结果: 40
		}

		{
			/*
			 * 2、常量表达式和编译器优化: 常量折叠
			 */
			// 2 * 16383 --> 32766
			// (-2) * 16384 --> -32768
			// 都在 short 范围内，常量表达式在编译优化后直接用对应的常量结果，然后编译器做强制转换
			// 等价于 short i = (short) (2 * 16383);
			short i = 2 * 16383;
			short j = (-2) * 16384;
			System.out.println("[xin10] i=" + i + ", j=" + j);
			// 2 * 16384 = 32768,超过 short 范围，编译器不会做转换
			// Type mismatch: cannot convert from int to short
			// short k = 2 * 16384;
			
			// 常量表达式在编译优化后直接用对应的常量结果，然后编译器做强制转换
			short cThirty = 3 * 10;
			short three = 3;
			short ten = 10;
			System.out.println("[xin11] " + (cThirty == three * ten));
			// Type mismatch: cannot convert from int to short
			// short thirty = three * ten;
			// final short ccThirty = three * ten;

			final short fTthree = 3;
			final short fTen = 10;
			// 常量表达式在编译优化后直接用对应的常量结果，然后编译器做强制转换
			short fThirty = fTthree * fTen;
			System.out.println("[xin12] fThirty=" + fThirty);
			final short ffThirty = fTthree * fTen;
			System.out.println("[xin13] ffThirty=" + ffThirty);
			
			final short a = 16384;
			final short b = 16383;
			// 常量表达式在编译优化后直接用对应的常量结果，然后编译器做强制转换
			short c = a + b;
			System.out.println("[xin14] c=" + c);
		}
	}
}
