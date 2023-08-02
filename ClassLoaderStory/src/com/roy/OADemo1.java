package com.roy;

/**
 * 模拟OA系统每个月计算工资
 */
public class OADemo1 {

	public static void main(String[] args) throws Exception {
		Double salary = 5000.00;
		Double money = 0.00;
		while(true) {
			money = calSalary(salary);
			System.out.println("实际到手Money:"+money);
			Thread.sleep(5000);
		}
	}
	//计算薪水
	private static Double calSalary(Double salary) {
//		SalaryCaler caler = new SalaryCaler();
//		return caler.cal(salary);
		return -1.00;
	}
}
