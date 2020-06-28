package com.chanpter1.oop;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Date;

/**
 * 面向过程：解决具体问题的过程
 * 面向对象：一种考虑问题的思维方式
 * 			1先整体再局部 2先抽象再具体 3能做什么，再怎么做
 * 	学习：1掌握一门面向对象语言的语法 2熟悉面向对象设计原则 3熟悉面向对象设计模式 23种设计模式
 * 
 * 类：一组具有相同特性和行为的事物集合   有共性就可以分类  抽象的
 * 类和对象关系：（抽象和具体的关系）
 * 		1类表示一个共性的产物，是一个综合的特征，而对象是一个个性的产物，是一个个性的特征
 * 		2类由属性和方法组成
 * 			属性：就相当于一个个的特征
 * 			方法：就相当于一个个的行为
 *    当堆中的对象没有引用指向时被JVM的GC视为垃圾对象 等待被回收
 *    一个对象在内存中的大小就是该对象所有属性所占内存大小的总和。引用类型变量在32位占4字节 64位占8字节还有一些隐藏数据的内存大小
 *@date:2019年9月12日 下午4:21:52
 */
public class BaseOfOOP {
	public static void main(String[] args) {
		/*Horse h=null;//声明一个类的变量
		h=new Horse();//创建一个horse类型的对象，实例对象  申请内存空间 在堆中产生对象
		h.age=4;
		h.name="小黑";
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
		System.out.println("结束");
		
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
	//在类中定义属性（特征）
	String name;//
	int age;
	
	public Horse() {
		
		System.out.println("horseConstructor...run");
		name="張三";
		age=15;
	}

	//在类中定义行为
	public void run(){
		System.out.println("我是"+name+"，我日行千里，我"+age+"岁了");
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
		System.out.println("哈哈哈");
	}
	
}

