package com.roy;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * ��Զ��jar���м��ؼ�����
 * 
 */
public class OADemo2 {

	public static void main(String[] args) throws Exception {
		Double salary = 5000.00;
		Double money;
		URL jarPath = new URL("file:D:\\lib\\SalaryCaler.jar");
		URLClassLoader urlClassLoader = new URLClassLoader(new URL[] { jarPath });
		while (true) {
			money = calSalary(salary, urlClassLoader);
			System.out.println("ʵ�ʵ���Money:" + money);

			Thread.sleep(5000);
		}
	}

	private static Double calSalary(Double salary, ClassLoader classloader) throws Exception {
		Class<?> clazz = classloader.loadClass("com.roy.SalaryCaler");
		if (null != clazz) {
			Object object = clazz.newInstance();
			return (Double) clazz.getMethod("cal", Double.class).invoke(object, salary);
		}
		return -1.00;
	}
}
