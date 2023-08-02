package com.roy.cl;

public class PriceTest01 {
	public static void main(String[] args) {
        //Price.P访问了类的静态变量，会触发类的初始化，即（加载，连接，初始化），
		//当执行构造函数时,apple还没有初始化完成，处于连接阶段的准备阶段，其值为默认值0，这时构造函数计算的price为-2.7
        System.out.println(Price01.P.price);// 结果为-2.7
    }
}

class Price01 {

    static Price01 P = new Price01(2.7);
    static double apple = 20;
    double price;

    public Price01(double orange) {
        price = apple - orange;
    }
}