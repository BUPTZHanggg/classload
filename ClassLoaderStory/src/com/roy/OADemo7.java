package com.roy;

/**
 * ʵ��ͬ���汾����
 * @author roy
 *
 */
public class OADemo7 {

	public static void main(String[] args) throws Exception {
		Double salary = 5000.00;
		Double money;
		
		while (true) {
			SalaryCaler caler = new SalaryCaler(); //��AppClassLoader�м��صļ�����
			System.out.println("ԭ���Ĺ��ʣ�"+caler.cal(salary));
			
			SalaryJarLoader salaryJarLoader = new SalaryJarLoader("D:\\lib\\SalaryCaler.jar");
			Class<?> clazz = salaryJarLoader.loadClass("com.roy.SalaryCaler");
			Object obj = clazz.newInstance();
//			//��ͬ������������е��಻��ǿת��
//			SalaryCaler caler2 = (SalaryCaler)obj;
//			money = caler2.cal(salary);
//			System.out.println("ʵ�ʵ��ֵĹ��ʣ�"+money);
			//���Է���
			money = (Double) clazz.getMethod("cal", Double.class).invoke(obj, salary);
			System.out.println("ʵ�ʵ��ֵĹ��ʣ�"+money);
//			
//			SalaryCaler caler2 = new SalaryCaler();
//			System.out.println("OAϵͳ���㵽�Ĺ���ʵ�ʵ��ֵĹ��ʣ�"+caler2.cal(salary));
			
			Thread.sleep(5000);
		}
	}
}
