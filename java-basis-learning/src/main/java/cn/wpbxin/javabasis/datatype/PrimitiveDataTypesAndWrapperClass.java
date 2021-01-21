package cn.wpbxin.javabasis.datatype;

/**
 * 原始数据类型及其包装器类型
 * @author wpbxin
 * @since 2020-12-20
 */
public class PrimitiveDataTypesAndWrapperClass {
	public static void main(String[] args) {
		{
			/**
			 * 自动装箱 Autoboxing 和 拆箱 Unboxing
			 */
			
			// 自动装箱 Autoboxing
			// Xxx.valueOf(xxx i)
			// 编译器会转成 Integer.valueOf(int i) 进行自动装箱
			Integer i = 100;
			Integer j = Integer.valueOf(100);
			System.out.println("i == j --> " + (i == j));
			j = Integer.valueOf(i);
			System.out.println("i == j --> " + (i == j));
			// 直接创建包装器类型的对象
			Integer k = new Integer(100);
			System.out.println("i == k --> " + (i == k));

			// 拆箱 Unboxing
			// Xxx..xxxValue()
			// 编译器会转成 Integer.intValue() 进行拆箱
			int m = i;
			System.out.println("i == m --> " + (i == m));
			System.out.println("===============1==============");
		}
		
		{
			/**
			 * 自动装箱 和 拆箱 的常见场景
			 */
			
			// 1、运算符：=、 +、 -、 *、 /、 %、== 、 < (<=) 、 > (>=)、? :
			int int256 = 256;
			Integer integer256 = 256;	// 自动装箱
			Integer integer255 = 255;	// 自动装箱
			boolean bl = true;
			// int 原始数据类型
			System.out.println(int256);
			// Object --> Integer 包装器类型 
			System.out.println(integer256);
			// 拆箱：int 原始数据类型
			// +、 -、 *、 /、 % 都是针对原始数据类型，都会自动拆箱
			System.out.println(integer256 + int256);
			System.out.println(integer256 - int256);
			System.out.println(integer256 * int256);
			System.out.println(integer256 / int256);
			System.out.println(integer256 % int256);
			System.out.println(integer256 + integer256);
			System.out.println(bl ? integer256 : int256);
			System.out.println(bl ? int256 : integer256);
			// Object --> 都是相同的 包装器类型 ，则结果是 包装器类型 
			System.out.println(bl ? integer255 : integer256);
			Long Long255 = 255L;
			// 包装器类型不同，会拆箱和自动类型提升：long 原始数据类型
			System.out.println(bl ? integer256 : Long255);
			System.out.println("===============2==============");

			// 如果是对象比较，则为 false ，表明是原始数据类型自动装箱
			// 如果是数值比较，则为 true ，表明是包装器类型自动拆箱
			// integer256 拆箱 --> result : true
			System.out.println(integer256 == int256);

			// int256 自动装箱 --> result : true
			System.out.println(integer256.equals(int256));

			// 默认 int 类型会自动装箱 Integer ，这里需明确标明为长整型，
			// 否则会报错：Type mismatch: cannot convert from int to Long
			Long Long256 = 256L;
			// 而原始数据类型则不会，原始数据类型可以自动进行类型提升
			long kk = 256;
			// Long256 拆箱 --> result : true
			System.out.println(Long256 == kk);

			// Long256 拆箱 --> result : true
			System.out.println(Long256 == int256);

			// int256 自动装箱 Integer 包装器类型，不同类型比较返回 false
			// result : false
			System.out.println(Long256.equals(int256));
			// result : false
			System.out.println(Long256.equals(integer256));
			System.out.println("===============3.0==============");

			// integer256 拆箱，int256 + int256 结果是 int 类型
			Long Long512 = 512L;
			// int256 + int256 结果是 int 类型，原始数据类型提升而 Long512 自动拆箱
			// result : true
			System.out.println(Long512 == (int256 + int256));
			// int256 + int256 自动装箱为 Integer
			// result : false
			System.out.println(Long512.equals(int256 + int256));
			System.out.println("===============3.1==============");
			
			// 结果同上
			System.out.println(Long512 == (int256 + integer256));
			System.out.println(Long512.equals(int256 + integer256));
			System.out.println("===============3.2==============");
			
			// 结果同上
			System.out.println(Long512 == (integer256 + integer256));
			System.out.println(Long512.equals(integer256 + integer256));
			System.out.println("===============3.3==============");
			
			// int256 + Long256 自动装箱 Long
			System.out.println(Long512 == (int256 + Long256));
			System.out.println(Long512.equals(int256 + Long256));
			System.out.println("===============3.4==============");
			
			// integer256 + Long256 自动装箱 Long
			System.out.println(Long512 == (integer256 + Long256));
			System.out.println(Long512.equals(integer256 + Long256));
			System.out.println("===============3.5==============");
		}
		
		{
			/**
			 * 包装器类型的缓存
			 */
			
			// Boolean 内部有 TRUE 和 FALSE 2个缓存实例
			Boolean newBoolean1 = new Boolean(true);
			Boolean newBoolean2 = new Boolean(true);
			Boolean primitiveBoolean = false;
			Boolean valueOfBoolean = Boolean.valueOf(false);
			System.out.println("newBoolean1 == newBoolean2 --> " + (newBoolean1 == newBoolean2));
			System.out.println("newBoolean1.equals(newBoolean2) --> " + newBoolean1.equals(newBoolean2));
			System.out.println("primitiveBoolean == valueOfBooleanb --> " + (primitiveBoolean == valueOfBoolean));
			
			// Integer 的缓存实例 IntegerCache 在 [-128, 127] 之间
			int i = 10;
			int j = 20;
			int k = 30;
			Integer ii = i + j;
			Integer jj = k;
			Integer kk = new Integer(30);
			// [-128, 127]之间的 Integer 缓存实例 --> result : true
			System.out.println(ii == jj);
			// 通过 new 的是全新的实例 --> result : false
			System.out.println(ii == kk);
			// 同类型的包装器实例的 equals 方法实则比较内部的原始数据值
			System.out.println(ii.equals(kk));
			ii = 128;
			jj = 128;
			// 超过 [-128, 127] 缓存范围 --> result : false
			System.out.println(ii == jj);
			System.out.println("===============4==============");
			
			// 其他的。。。
		}
		Integer integer128_1 = 128;
		Integer integer128_2 = 128;
		System.out.println(integer128_1 == integer128_2);
	}
}
