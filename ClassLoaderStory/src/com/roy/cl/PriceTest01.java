package com.roy.cl;

public class PriceTest01 {
	public static void main(String[] args) {
        //Price.P��������ľ�̬�������ᴥ����ĳ�ʼ�����������أ����ӣ���ʼ������
		//��ִ�й��캯��ʱ,apple��û�г�ʼ����ɣ��������ӽ׶ε�׼���׶Σ���ֵΪĬ��ֵ0����ʱ���캯�������priceΪ-2.7
        System.out.println(Price01.P.price);// ���Ϊ-2.7
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