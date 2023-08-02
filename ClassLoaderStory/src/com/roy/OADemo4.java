package com.roy;

/**
 * ��jar���м���class�ļ���
 * @author roy
 *
 */
public class OADemo4 {
	public static void main(String[] args) throws Exception {
		Double salary = 5000.00;
		Double money;

		SalaryJarLoader salaryJarLoader = new SalaryJarLoader("D:\\lib\\SalaryCaler.jar");
		System.out.println(salaryJarLoader.getParent());
//		while (true) {
//			money = calSalary(salary,salaryJarLoader);
//			System.out.println("ʵ�ʵ���Money:"+money);
//
//			Thread.sleep(5000);
//		}
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
