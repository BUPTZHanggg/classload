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
		// Price.P��������ľ�̬�������ᴥ����ĳ�ʼ�����������أ����ӣ���ʼ��������ִ�й��캯��ʱ
		// apple�Ѿ�����˳�ʼ������ֵΪ20�ˣ���ʱ���캯�������priceΪ17.3
		System.out.println(Price03.P.price);// ���Ϊ17.3
	}
}
