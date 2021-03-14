package cn.wpbxin.javabasis.initialization;

/**
 * 初始化顺序：父类静态变量、父类静态代码块、子类静态变量、子类静态代码块、
 * 父类非静态变量、父类非静态代码块、父类构造函数、子类非静态变量、子类非静态代码块、子类构造函数
 * @author wpbxin
 * @since 2021-03-14
 */
public class OrderOfInitialization {
	public static void main(String[] args) {
		// 只会初始化父类，子类不会初始化
		// System.out.println(SubClass.superStaticField_1);
		// 子类初始化
		// System.out.println(SubClass.subclassStaticField_2);
		// System.out.println(SuperClass.superStaticField_1);
		new SubClass();
	}
}
