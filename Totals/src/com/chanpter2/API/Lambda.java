package com.chanpter2.API;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1.8�����ڴ���������
 * 	lambda���ʽ����Ϊ�հ���java���Բ����ϵĸı�,lambda����Ѻ�����Ϊһ�������Ĳ���
 * 			��������Ϊ�������ݽ������У������߰Ѵ��뿴�����ݣ�
 * 			Lambda���ʽ���ڼ�java�нӿڷ�ʽ�������ڲ��࣬����Ϊ����ʽ�ӿڵĸ��
 * 			����ʽ�ӿھ���һ������һ����������ͨ�ӿڡ��������Ľӿڣ����Ա���ʽת��Ϊlambda���ʽ
 * 
 * 	�﷨��������1������2��...��->{...}
 * 
 *   ע��  ��ֻ�ʺ�һ���ӿ���ֻ��һ�����󷽷��ĳ��� 
 *   		Ĭ�Ϸ����;�̬������Ӱ�캯��ʽ����Լ
 *@version:
 *@Description: 
 *@author :�⾧
 *@date:2019��9��24�� ����7:58:24
 */
public class Lambda {
	public static void main(String[] args) {
//		IEat i=new IEatImpl();
//		i.eat();
//		
//		IEat i1=new IEat() {
//			@Override
//			public void eat() {
//				System.out.println("eat banana");
//			}
//		};
//		i1.eat();
		
		//lambda���ʽ��д��
		//��̎��1������ 2���ᵥ������class�ļ� 
		
		//1�޲�����ʱ��
//		IEat i3 = ()->{System.out.println("eat orage");};
//		IEat i4 = ()->System.out.println("eat dongdongbao");
//		i3.eat();
//		i4.eat();
		//2�в���
		//IEat i3 =(String thing)->System.out.println("eat"+thing);
//		IEat i3 =(thing,name)->System.out.println(name+"eat..."+thing);
//		i3.eat("dongdongbao","����");
//		IEat i3 =(thing,name)->{
//			System.out.println(name+"eat..."+thing);
//			System.out.println(name+"eat..."+thing);
//		};
//		i3.eat("dongdongbao","����");
		//3������ֵ�ķ���
//		IEat i3 =(thing,name)->{
//			System.out.println(name + "eat..."+thing);
//			return 10;
//		};
//		int sum = i3.eat("dongdongbao", "zhangsan");
//		System.out.println(sum);
//		IEat i3 =(thing,name)->10;
//		System.out.println(i3.eat("ս��", "dongdongbao"));
		IEat i3 =(final String thing,final String name)->{return 10;};
		System.out.println(i3.eat("orange", "zhangsan"));
		
		Student[] ss={new Student(15, "����")
				,new Student(55, "likui")
				,new Student(66, "liangl")};
//		Arrays.sort(ss, new Comparator<Student>() {
//			@Override
//			public int compare(Student o1, Student o2) {
//				return o1.getAge()-o2.getAge();
//			}
//		});
		Arrays.sort(ss, (o1,o2)->o2.getAge()-o1.getAge());
		System.out.println(Arrays.toString(ss));
		
		
	}
}
//ֻ��һ�����󷽷��Ľӿ�
interface IEat{ public abstract int eat(final String thing,final String name);}
class IEatImpl implements IEat{

	@Override
	public int eat(final String thing,final String name) {
		System.out.println("eat apple");
		return 10;
	}
}
class Student{
	private int age;
	private String name;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Student(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Student [age=" + age + ", name=" + name + "]";
	}
	
}