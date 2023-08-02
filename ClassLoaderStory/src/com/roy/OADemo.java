package com.roy;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.Iterator;
import java.util.ServiceLoader;
import java.util.concurrent.TimeUnit;

import com.roy.spi.SalaryCalService;

public class OADemo {

	public static void main(String[] args) throws Exception {
		Double salary = 2000.00;
		Double money;
//		URL jarPath = new URL("file:D:\\lib\\SalaryCaler.jar");
//		URLClassLoader urlClassLoader = new URLClassLoader(new URL[] {jarPath});

		SalaryClassLoader salaryClassLoader = new SalaryClassLoader("E:\\workspace-eclipse2\\SalaryCaler\\bin\\");

//		SalaryJarLoader salaryJarLoader = new SalaryJarLoader("D:\\lib\\SalaryCaler.jar");
		while (true) {
//			money = calSalary(salary,urlClassLoader);
			money = calSalary(salary,salaryClassLoader);
			System.out.println("ʵ�ʵ���Money:"+money);
//			SalaryCaler caler= new SalaryCaler();//��AppClassLoader������س�����SalaryCaler��
//			System.out.println("ԭ���Ĺ��ʣ�"+caler.cal(salary));

			SalaryJarLoader classloader1 = new SalaryJarLoader("D:\\lib\\SalaryCaler.jar");
			ServiceLoader<SalaryCalService> services = ServiceLoader.load(SalaryCalService.class, classloader1);
			Iterator<SalaryCalService> iterator = services.iterator();
			if (iterator.hasNext()) {
				SalaryCalService service1 = iterator.next();
				System.out.println("原始工资"+service1.cal(salary));
			}
			//			Class<?> clazz = classloader.loadClass("com.roy.SalaryCaler");
//			if(null!= clazz) {
//				Object object = clazz.newInstance();
//				System.out.println("原始工资"+(Double)clazz.getMethod("cal", Double.class).invoke(object, salary));
//			}

//			SalaryCalService service1 = getSalaryService(classloader);
//			System.out.println("ԭ���Ĺ��ʣ�" + service1.cal(salary));

			SalaryJarLoader classloader2 = new SalaryJarLoader("D:\\lib\\SalaryCaler.jar");
			Class<?> clazz2 = classloader2.loadClass("com.roy.SalaryCaler");
			if(null!= clazz2) {
				Object object2 = clazz2.newInstance();
				System.out.println("修改后工资"+(Double)clazz2.getMethod("cal", Double.class).invoke(object2, salary));
			}
			
//			SalaryCalService service2 = getSalaryService(classloader2);
//			System.out.println("ʵ�ʵ��ֵĹ��ʣ�" + service1.cal(salary));

//			money = calSalary(salary);//�������2�ɵĹ��ʡ�
//			System.out.println("ʵ�ʵ��ֵĹ��ʣ�"+money);
			Thread.sleep(5000);
		}
	}

//	private static SalaryCalService getSalaryService(SalaryJarLoader classloader) {
//		SalaryCalService service = null;
//		ClassLoader cl = Thread.currentThread().getContextClassLoader();
//		try {
//			Thread.currentThread().setContextClassLoader(classloader);
//			ServiceLoader<SalaryCalService> services = ServiceLoader.load(SalaryCalService.class);
//			Iterator<SalaryCalService> iterator = services.iterator();
//			if (iterator.hasNext()) {
//				service = iterator.next();
//			}
//		} finally {
//			Thread.currentThread().setContextClassLoader(cl);
//		}
//		return service;
//	}

	private static Double calSalary(Double salary,ClassLoader classloader) throws Exception {
//	private static Double calSalary(Double salary) throws Exception {
//		SalaryCaler caler = new SalaryCaler();
//		return caler.cal(salary);
//		SalaryJarLoader classloader = new SalaryJarLoader("D:\\lib\\SalaryCaler.jar");
		Class<?> clazz = classloader.loadClass("com.roy.SalaryCaler");
////		System.out.println(clazz.getClassLoader());
////		System.out.println(clazz.getClassLoader().getParent());
		if (null != clazz) {
			Object object = clazz.newInstance();
			return (Double) clazz.getMethod("cal", Double.class).invoke(object, salary);
		}
		return -1.00;
	}

	private static Double calSalary(Double salary) throws Exception {
		SalaryJarLoader classloader = new SalaryJarLoader("D:\\lib\\SalaryCaler.jar");
		Class<?> clazz = classloader.loadClass("com.roy.SalaryCaler");
		if (null != clazz) {
			Object object = clazz.newInstance();
			return (Double) clazz.getMethod("cal", Double.class).invoke(object, salary);
		}
		return -1.00;
	}
}
