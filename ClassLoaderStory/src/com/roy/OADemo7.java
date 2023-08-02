package com.roy;

/**
 * 实现同类多版本加载
 * @author roy
 *
 */
public class OADemo7 {

	public static void main(String[] args) throws Exception {
		Double salary = 5000.00;
		Double money;
		
		while (true) {
			SalaryCaler caler = new SalaryCaler(); //从AppClassLoader中加载的计算类
			System.out.println("原本的工资："+caler.cal(salary));
			
			SalaryJarLoader salaryJarLoader = new SalaryJarLoader("D:\\lib\\SalaryCaler.jar");
			Class<?> clazz = salaryJarLoader.loadClass("com.roy.SalaryCaler");
			Object obj = clazz.newInstance();
//			//不同类加载器缓存中的类不能强转。
//			SalaryCaler caler2 = (SalaryCaler)obj;
//			money = caler2.cal(salary);
//			System.out.println("实际到手的工资："+money);
			//可以反射
			money = (Double) clazz.getMethod("cal", Double.class).invoke(obj, salary);
			System.out.println("实际到手的工资："+money);
//			
//			SalaryCaler caler2 = new SalaryCaler();
//			System.out.println("OA系统中算到的工资实际到手的工资："+caler2.cal(salary));
			
			Thread.sleep(5000);
		}
	}
}
