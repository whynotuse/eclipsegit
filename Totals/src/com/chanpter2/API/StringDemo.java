package com.chanpter2.API;

/**
 * 
 * @version:
 * @Description:
 * @author :�⾧
 * @date:2019��9��19�� ����5:00:12
 */
public class StringDemo {

	public static void main(String[] args) {

		String str1 = "����";// �Ƽ�ʹ�õķ�ʽ �����ַ����������д洢"����" ���ص�ַ��ֵstr1 һ������

		str1 = new String("haha");// һ���������� new һ���ڶ� "haha"�ڳ�����
		
		//4�����������ֱ�Ӹ�ֵ�ַ�������ʱ�����Ǳ����ں�������
		//����ڱ����ڿ���ȷ������ô��ʹ�����еĶ��󣬷���ᴴ���µĶ���
		String a = "a";
		String a1 = a + 1;//�ڶ��д�������
		String a2 = "a1";
		System.out.println(a1 == a2);//false
		
		final String b="b";
		String b1=b+1;//�൱�� "b"+1  �����Ż�Ϊ"b1"
		String b2="b1";
		System.out.println(b1==b2);//true
		
		String c=getC();
		String c1=c+1;
		String c2="c1";
		System.out.println(c1==c2);//false
		
		final String d=getD();//�����ڲ���ȷ��������ֵ
		String d1=d+1;//��Ȼ��final ���ǲ���ȷ��ֵ ���Բ����Ż� ���ǻᴴ������
		String d2="d1";
		System.out.println(d1==d2);//false

	}

	private static String getD() {
		return "d";
	}

	private static String getC() {
		return "c";
	}
}
