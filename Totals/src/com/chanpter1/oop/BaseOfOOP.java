package com.chanpter1.oop;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Date;

/**
 * ������̣������������Ĺ���
 * �������һ�ֿ��������˼ά��ʽ
 * 			1�������پֲ� 2�ȳ����پ��� 3����ʲô������ô��
 * 	ѧϰ��1����һ������������Ե��﷨ 2��Ϥ����������ԭ�� 3��Ϥ����������ģʽ 23�����ģʽ
 * 
 * �ࣺһ�������ͬ���Ժ���Ϊ�����Ｏ��   �й��ԾͿ��Է���  �����
 * ��Ͷ����ϵ��������;���Ĺ�ϵ��
 * 		1���ʾһ�����ԵĲ����һ���ۺϵ���������������һ�����ԵĲ����һ�����Ե�����
 * 		2�������Ժͷ������
 * 			���ԣ����൱��һ����������
 * 			���������൱��һ��������Ϊ
 *    �����еĶ���û������ָ��ʱ��JVM��GC��Ϊ�������� �ȴ�������
 *    һ���������ڴ��еĴ�С���Ǹö�������������ռ�ڴ��С���ܺ͡��������ͱ�����32λռ4�ֽ� 64λռ8�ֽڻ���һЩ�������ݵ��ڴ��С
 *@date:2019��9��12�� ����4:21:52
 */
public class BaseOfOOP {
	public static void main(String[] args) {
		/*Horse h=null;//����һ����ı���
		h=new Horse();//����һ��horse���͵Ķ���ʵ������  �����ڴ�ռ� �ڶ��в�������
		h.age=4;
		h.name="С��";
		h.run();*/
		/*com.test.Horse h=new com.test.Horse();
		com.test.Horse h1=new com.test.Horse();
		h.setAge(-10);
		h1.setAge(10);
		System.out.println(h);
		System.out.println(h1);*/
//		int sum=sum(10,10);
//		System.out.println(sum);//20
		/*int x=10;
		change(x);
		System.out.println(x);//10
//		{int c=10;System.out.println(c);}
		Horse h=new Horse();
		h.age=100;
		redirect(h);
		System.out.println(h.age);//10
*/		
		//new LV().run();
		System.out.println(divide(10,0));
		System.out.println("����");
		
	}

	private static int divide(int i, int j) {
		try {
			return i / j;
		} catch (Exception e) {
			String message = e.getMessage();
//			System.out.println(message);
			message+=new Date();
			e = new Exception(message);
			try {
				e.printStackTrace(new PrintStream("d:logg.txt"));
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return -1;
	}

	public static void change(int x) {
		// TODO Auto-generated method stub
		x+=10;
	}

	private static void redirect(Horse h) {
		// TODO Auto-generated method stub
		h.age=10;
	}

	private static int sum(int i, int j) {
		// TODO Auto-generated method stub
		return i+j;
	}
	
}
class Horse{
	//�����ж������ԣ�������
	String name;//
	int age;
	
	public Horse() {
		
		System.out.println("horseConstructor...run");
		name="����";
		age=15;
	}

	//�����ж�����Ϊ
	public void run(){
		System.out.println("����"+name+"��������ǧ���"+age+"����");
	}
}
class LV extends Horse{


	public LV() {
		//super();
		this("hahh");
		System.out.println();
	}
	public LV(String name) {
		super();
		System.out.println("������");
	}
	
}

