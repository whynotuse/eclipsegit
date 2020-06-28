package com.chanpter2.API;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;

/**
 * ���ִ�������
 * 	BigInteger:�����ó���integer��Χ�����ֽ������㡢
 * ���췽�� public BigIntger(String val){}
 * ���÷��� �Ӽ��˳�
 * BigDecimal:���������ʱ��float��double�����׶�ʧ���ȣ�
 * 			Ϊ���ܾ�ȷ�ı�ʾ�����㸡������java�ṩ��BigDecimal�����ɱ�ģ����⾫�ȵ��з���ʮ������
 * 	���췽�� public BigDecimal(String val){}
 *���÷��� �Ӽ��˳� 
 *@version:
 *@Description: 
 *@author :�⾧
 *@date:2019��9��24�� ����6:48:41
 */
public class BigDecimaltest {
	public static void main(String[] args) {
		//bigInt();
		bigDec();
	}

	private static void bigDec() {
			String val1="4565.415645678612315645165";
			String val2="562.45648678264655465456";
			BigDecimal b1=new BigDecimal(val1);
			BigDecimal b2=new BigDecimal(val2);
			System.out.println(b1.add(b2));
			System.out.println(b1.subtract(b2));
			System.out.println(b1.multiply(b2));
		try {
			System.out.println(b1.divide(b2));//������������ �����쳣
		} catch (ArithmeticException e) {
			System.out.println("��������");
		}
	}

	private static void bigInt() {
			//������������
		String val1= "77288556415631534948";
		String val2= "6546545616518914564";
		BigInteger bi1=new BigInteger(val1);
		BigInteger bi2=new BigInteger(val2);
		
		System.out.println(bi1.add(bi2));//�ӷ�
		System.out.println(bi1.subtract(bi2));//����
		System.out.println(bi1.multiply(bi2));//�˷�
		System.out.println(bi1.divide(bi2));//����
		System.out.println(bi1.remainder(bi2));//ȡģ
		
		System.out.println(Arrays.toString(bi1.divideAndRemainder(bi2))); //������ȡ��
		
	}
}
