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
	        //apple�ڱ���׶ξ���ɸ�ֵ�ˣ���ֵΪ20����ʱ���캯�������priceΪ17.3
	        System.out.println(Price02.P.price);// ���Ϊ17.3
	    }
}
