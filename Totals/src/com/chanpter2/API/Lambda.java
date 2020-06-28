package com.chanpter2.API;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1.8最受期待的新特性
 * 	lambda表达式（称为闭包）java语言层面上的改变,lambda允许把函数作为一个方法的参数
 * 			（函数作为参数传递进方法中），或者把代码看成数据，
 * 			Lambda表达式用于简化java中接口方式的匿名内部类，被称为函数式接口的概念。
 * 			函数式接口就是一个具有一个方法的普通接口。像这样的接口，可以被隐式转换为lambda表达式
 * 
 * 	语法：（参数1，参数2，...）->{...}
 * 
 *   注意  ：只适合一个接口中只有一个抽象方法的场合 
 *   		默认方法和静态方法不影响函数式的契约
 *@version:
 *@Description: 
 *@author :衡晶
 *@date:2019年9月24日 下午7:58:24
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
		
		//lambda表达式的写法
		//好處：1代码简洁 2不会单独生成class文件 
		
		//1无参数的时候
//		IEat i3 = ()->{System.out.println("eat orage");};
//		IEat i4 = ()->System.out.println("eat dongdongbao");
//		i3.eat();
//		i4.eat();
		//2有参数
		//IEat i3 =(String thing)->System.out.println("eat"+thing);
//		IEat i3 =(thing,name)->System.out.println(name+"eat..."+thing);
//		i3.eat("dongdongbao","张三");
//		IEat i3 =(thing,name)->{
//			System.out.println(name+"eat..."+thing);
//			System.out.println(name+"eat..."+thing);
//		};
//		i3.eat("dongdongbao","张三");
		//3带返回值的方法
//		IEat i3 =(thing,name)->{
//			System.out.println(name + "eat..."+thing);
//			return 10;
//		};
//		int sum = i3.eat("dongdongbao", "zhangsan");
//		System.out.println(sum);
//		IEat i3 =(thing,name)->10;
//		System.out.println(i3.eat("战三", "dongdongbao"));
		IEat i3 =(final String thing,final String name)->{return 10;};
		System.out.println(i3.eat("orange", "zhangsan"));
		
		Student[] ss={new Student(15, "张三")
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
//只有一个抽象方法的接口
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