package cn.wpbxin.javabasis.initialization;

public class SubClass extends SuperClass{

	public static void main(String[] args) {
		// System.out.println(InitializationOrderSuperClass.superStaticField_1);
		// System.out.println(InitializationOrderSuperClass.superStaticField_1);
		// new InitializationOrderSubClass();
		// new InitializationOrderSubClass();
		// System.out.println(InitializationOrderSubClass.subclassStaticField_1);
		// nothing
		new SubClass();
	}
	
	public SubClass() {
		super();
		System.out.println("SubClass Constructor");
	}
	
	static {
		System.out.println("SubClass begin");
	}
	
	// 静态变量/类变量 1
	private static String subclassStaticField_1 = "SubClass subclassStaticField_1";
	
	// 实例变量 1
	public String subclassInstanceField_1 = "SubClass subclassInstanceField_1";
	
	static {
		System.out.println(subclassStaticField_1);
		// Cannot reference a field before it is defined
		// System.out.println(subclassStaticField_2);
	}
	
	public static String subclassStaticField_2 = "SubClass subclassStaticField_2";
	
	{
		System.out.println(subclassStaticField_1);
	}
	
	// 实例变量 2
	public String subclassInstanceField_2 = "SubClass subclassInstanceField_2";
	
	static {
		System.out.println(subclassStaticField_2);
	}
	
	{
		System.out.println(subclassInstanceField_2);
	}
}
