package com.roy;

/**
 * �Զ���ʵ���ȼ��� 
 */
public class OADemo5 {

	public static void main(String[] args) throws Exception {
		Double salary = 5000.00;
		Double money;
		
		while (true) {
			money = calSalary(salary);
			System.out.println("ʵ�ʵ���Money:"+money);

			Thread.sleep(5000);
		}
	}
	
	private static Double calSalary(Double salary) throws Exception {
		SalaryJarLoader salaryJarLoader = new SalaryJarLoader("D:\\lib\\SalaryCaler.jar");
		Class<?> clazz = salaryJarLoader.loadClass("com.roy.SalaryCaler");
//		System.out.println(clazz.getClassLoader());
//		System.out.println(clazz.getClassLoader().getParent());
		if (null != clazz) {
			Object object = clazz.newInstance();
			return (Double) clazz.getMethod("cal", Double.class).invoke(object, salary);
		}
		return -1.00;
	}
}
