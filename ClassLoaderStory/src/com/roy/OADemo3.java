package com.roy;

/**
 * 从.myclass文件中加载计算类 
 */
public class OADemo3 {
	public static void main(String[] args) throws Exception {
		Double salary = 5000.00;
		Double money;

		SalaryClassLoader salaryClassLoader = new SalaryClassLoader("E:\\workspace-eclipse2\\SalaryCaler\\bin\\");

		while (true) {
			money = calSalary(salary,salaryClassLoader);
			System.out.println("实际到手Money:"+money);

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
