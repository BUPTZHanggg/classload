package com.roy.cl;

class Price02 {
    static Price02 P = new Price02(2.7);
    final static double apple = 20;
    double price;
    
    public Price02(double orange) {
        price = apple - orange;
    }
}

public class PriceTest02 {
	 public static void main(String[] args) {
	        //apple在编译阶段就完成赋值了，其值为20，这时构造函数计算的price为17.3
	        System.out.println(Price02.P.price);// 结果为17.3
	    }
}
