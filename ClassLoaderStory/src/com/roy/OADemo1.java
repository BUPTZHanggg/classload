package com.roy;

/**
 * ģ��OAϵͳÿ���¼��㹤��
 */
public class OADemo1 {

	public static void main(String[] args) throws Exception {
		Double salary = 5000.00;
		Double money = 0.00;
		while(true) {
			money = calSalary(salary);
			System.out.println("ʵ�ʵ���Money:"+money);
			Thread.sleep(5000);
		}
	}
	//����нˮ
	private static Double calSalary(Double salary) {
//		SalaryCaler caler = new SalaryCaler();
//		return caler.cal(salary);
		return -1.00;
	}
}
