package com.chanpter1.oop;
/**
 * =================================================
 * �ڲ��������һ�����ж������  λ�ã���Ա ��̬  �����ڲ�
 * 
 * 
 */
public class InnerClassDesc {
	public static void main(String[] args) {
		//new Outer_1().new Inner().print();//���ⲿ������Ա�ڲ��� ������
		new Outer_1().innerPrint();//����ʹ�ô��ַ�ʽ���ⲿ����ʹ���ڲ���
		new Outer_1().show(3);//�����ڲ���
		new Outer_1.inner3().show();
		new Outer_1().print();
		new Outer_1().print_1();
		//������ʽ�����ڲ���
		new Outer_1().print_2(new eat() {
			
			@Override
			public void eat() {
				System.out.println("eat():������ʽ�������ڲ���");
			}
		});
	}
}

class Outer_1{
	private String name = "outer_1";
	public void innerPrint(){new Inner().print();}
	//===================��Ա�ڲ���==================================== ����private
	private class Inner{//���ԭ�� �����ⲿ����ʹ�� �������ⲿʹ�� Ҳ���������ڲ��� ���Ҫ����ʹ�ý����ṩ��ȡ�ķ���
		public void print(){ System.out.println("��Ա�ڲ���");}
	}
	
	//==================================�����ڲ���===============================
	public void show(final int y){
		//show�����ľֲ������򷽷��Ĳ���ʵ���ϱ���Ϊ���� final
		int i=0;
		final int x=0;
		class inner2{
			public void show(){
				//innerPrint();
				System.out.println(name);//�������ⲿ������г�Ա ûҪ��
				System.out.println(x);
				System.out.println(y);//����Ҳ��final
				System.out.println(i);//jdk1.8Ĭ��Ϊfinal
//				x++;           //�����ڲ��಻��ʹ�ø��ڲ������ڷ����ķ�final�ֲ�����
				System.out.println("�����ڲ���");
			}
		}
		inner2 inner=new inner2();//�����ڲ���ֻ���ڸ÷�����ʵ�������ҵ������Ա �ⲿ����ʵ����
		inner.show();
	}
	//================================��̬�ڲ���=======================================
	//���ڲ��������������̬��Աһ����û���ⲿ�����ʱ��Ҳ�ܹ�����������̬Ƕ������ܷ����ⲿ��ľ�̬��Ա�ͷ���
	//���ֵ��Ƿ�װ
	static class inner3{
		public void show() {
//			System.out.println("��̬�ڲ���" + name);//���ܷ����ⲿ���еķǾ�̬�ֶ�
			System.out.println("��̬�ڲ���" );
		}
	}
	//===============================�����ڲ���===========================================
	/**
	 * û�����ֵ��ڲ���  1 �̳з�ʽ(��Ϊ������ļ̳�)�������ڲ���  2 �ӿڷ�ʽ�������ڲ���  3 ������ʽ�������ڲ���
	 *    1 �����й��췽����ֻ����һ��ʵ��
	 *    2 ���ܶ����κξ�̬��Ա�;�̬����
	 *    3 ������public,protected,private,static
	 *    4 һ�����ڴ�������new�ĺ��棬��������ʵ��һ���ӿڻ���д����ķ����ķ�ʽ
	 *    5 �����ڲ���Ϊ�ֲ��ģ����Ծֲ��ڲ�����������ƶ�����Ч
	 */
	//�̳з�ʽ�����ڲ���
	public void print(){
		
		Cat cat=new Cat() {
//			public Cat(){}  �����й��췽��  ֻ����һ��ʵ�� ֻ��һ��
			@Override
			public void eat() {
				System.out.println("eat():�̳з�ʽ�����ڲ���");
			}
		};
		cat.eat();
	}
	//�ӿڷ�ʽ�����ڲ���
	public void print_1(){
		
		eat eat=new eat() {
			
			@Override
			public void eat() {
				System.out.println("eat():�ӿڷ�ʽ�������ڲ���");
			}
		};
		eat.eat();
	}
	//������ʽ�������ڲ���
	public void print_2(eat eat){
		eat.eat();
	}
}
interface eat{  void eat();}
abstract class Cat{ public abstract void eat();}
