package com.roy.cl;

class Price03 {
	static double apple = 20;
	static Price03 P = new Price03(2.7);
	double price;

	public Price03(double orange) {
		price = apple - orange;
	}
}

public class PriceTest03 {
	public static void main(String[] args) {
		// Price.P访问了类的静态变量，会触发类的初始化，即（加载，连接，初始化），当执行构造函数时
		// apple已经完成了初始化，其值为20了，这时构造函数计算的price为17.3
		System.out.println(Price03.P.price);// 结果为17.3
	}
}
