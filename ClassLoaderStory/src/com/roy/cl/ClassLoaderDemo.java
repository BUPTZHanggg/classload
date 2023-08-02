package com.roy.cl;

public class ClassLoaderDemo {
	
//	public static final int a = 10;
//	static {
//		System.out.println("aaaaaa");
//	}
//	private int b;
//	public ClassLoaderDemo() {
//		System.out.println("bbbbb");
//		this.b=10;
//	}
	
	public static void main(String[] args) throws Exception {
		// ���ӹ�ϵ AppClassLoader <- ExtClassLoader <- BootStrap Classloader
		ClassLoader cl1 = ClassLoaderDemo.class.getClassLoader();
		System.out.println("cl1 > " + cl1);
		System.out.println("parent of cl1 > " + cl1.getParent());
		// BootStrap Classloader��C++��������JVM�������һ���֣�������JAVA�ࡣ
		System.out.println("grant parent of cl1 > " + cl1.getParent().getParent());
		// String,Int�Ȼ�������BootStrap Classloader���ء�
		ClassLoader cl2 = String.class.getClassLoader();
		System.out.println("cl2 > " + cl2);
		System.out.println(cl1.loadClass("java.util.List").getClass().getClassLoader());

		// javaָ�����ͨ������-verbose:class -verbose:gc ����������ʱ��ӡ����������
		// BootStrap Classloader������java�����ࡣ������Բ�����javaָ����ָ�����ƶϲ�����java���Դ�����
		System.out.println("BootStrap ClassLoader����Ŀ¼��" + System.getProperty("sun.boot.class.path"));
		// Extention Classloader ����JAVA_HOME/ext�µ�jar���� ��ͨ��-D java.ext.dirs����ָ��Ŀ¼
		System.out.println("Extention ClassLoader����Ŀ¼��" + System.getProperty("java.ext.dirs"));
		// AppClassLoader ����CLASSPATH��Ӧ���µ�Jar������ͨ��-D java.class.path����ָ��Ŀ¼
		System.out.println("AppClassLoader����Ŀ¼��" + System.getProperty("java.class.path"));
	}
}
