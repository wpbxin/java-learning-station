package cn.wpbxin.javabasis.initialization;

public class SuperClass {
	
	public static void main(String[] args) {
		new SuperClass();
	}
	
	public SuperClass() {
		System.out.println("SuperClass Constructor");
	}
	
	static {
		System.out.println("SuperClass begin");
	}
	
	// 静态变量/类变量 1
	public static String superStaticField_1 = "SuperClass superStaticField_1";

	// 实例变量 1
	private String superInstanceField_1 = "SuperClass superInstanceField_1";
	
	static {
		System.out.println(superStaticField_1);
		// Cannot reference a field before it is defined
		// System.out.println(superStaticField_2);
	}
	
	private static String superStaticField_2 = "SuperClass superStaticField_2";
	
	{
		System.out.println(superInstanceField_1);
	}
	
	// 实例变量 2
	private String superInstanceField_2 = "SuperClass superInstanceField_2";
	
	static {
		System.out.println(superStaticField_2);
	}
	
	{
		System.out.println(superInstanceField_2);
	}
	
}
