package com.roy;

import java.util.Iterator;
import java.util.ServiceLoader;

import com.roy.spi.SalaryCalService;

/**
 * 使用SPI实现同类多版本加载
 */
public class OADemo8 {

	public static void main(String[] args) throws Exception {
		Double salary = 5000.00;

		while (true) {
			SalaryJarLoader salaryJarLoader = new SalaryJarLoader("D:\\lib\\SalaryCaler.jar");
			SalaryCalService service = getSalaryService(salaryJarLoader);
			System.out.println("原本的工资："+service.cal(salary));

			SalaryJarLoader salaryJarLoader2 = new SalaryJarLoader("D:\\lib2\\SalaryCaler.jar");
			SalaryCalService service2 = getSalaryService(salaryJarLoader2);
			System.out.println("实际到手的工资："+service2.cal(salary));
			Thread.sleep(5000);
		}
	}

	private static SalaryCalService getSalaryService(SalaryJarLoader classloader) {
		SalaryCalService service = null;
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		try {
			Thread.currentThread().setContextClassLoader(classloader);
			ServiceLoader<SalaryCalService> services = ServiceLoader.load(SalaryCalService.class);
			Iterator<SalaryCalService> iterator = services.iterator();
			if (iterator.hasNext()) {
				service = iterator.next();
			}
		} finally {
			Thread.currentThread().setContextClassLoader(cl);
		}
		return service;
	}
}
