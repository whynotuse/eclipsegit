package com.chanpter1.oop;
/**
 * =================================================
 * 内部类就是在一个类中定义的类  位置：成员 静态  方法内部
 * 
 * 
 */
public class InnerClassDesc {
	public static void main(String[] args) {
		//new Outer_1().new Inner().print();//在外部创建成员内部类 不建议
		new Outer_1().innerPrint();//建议使用此种方式在外部类中使用内部类
		new Outer_1().show(3);//方法内部类
		new Outer_1.inner3().show();
		new Outer_1().print();
		new Outer_1().print_1();
		//参数方式匿名内部类
		new Outer_1().print_2(new eat() {
			
			@Override
			public void eat() {
				System.out.println("eat():参数方式的匿名内部类");
			}
		});
	}
}

class Outer_1{
	private String name = "outer_1";
	public void innerPrint(){new Inner().print();}
	//===================成员内部类==================================== 建议private
	private class Inner{//设计原则 是能外部类来使用 不建议外部使用 也就隐藏了内部类 如果要对外使用建议提供获取的方法
		public void print(){ System.out.println("成员内部类");}
	}
	
	//==================================方法内部类===============================
	public void show(final int y){
		//show方法的局部变量或方法的参数实际上必需为常量 final
		int i=0;
		final int x=0;
		class inner2{
			public void show(){
				//innerPrint();
				System.out.println(name);//随便访问外部类的所有成员 没要求
				System.out.println(x);
				System.out.println(y);//参数也是final
				System.out.println(i);//jdk1.8默认为final
//				x++;           //方法内部类不能使用该内部类所在方法的非final局部变量
				System.out.println("方法内部类");
			}
		}
		inner2 inner=new inner2();//方法内部类只能在该方法中实例化并且调用其成员 外部不能实例化
		inner.show();
	}
	//================================静态内部类=======================================
	//该内部类可以像其他静态成员一样，没有外部类对象时，也能够访问它。静态嵌套类仅能访问外部类的静态成员和方法
	//体现的是封装
	static class inner3{
		public void show() {
//			System.out.println("静态内部类" + name);//不能访问外部类中的非静态字段
			System.out.println("静态内部类" );
		}
	}
	//===============================匿名内部类===========================================
	/**
	 * 没有名字的内部类  1 继承方式(多为抽象类的继承)的匿名内部类  2 接口方式的匿名内部类  3 参数方式的匿名内部类
	 *    1 不能有构造方法，只能有一个实例
	 *    2 不能定义任何静态成员和静态方法
	 *    3 不能是public,protected,private,static
	 *    4 一定是在创建对象new的后面，用其隐含实现一个接口或重写父类的方法的方式
	 *    5 匿名内部类为局部的，所以局部内部类的所有限制对其生效
	 */
	//继承方式匿名内部类
	public void print(){
		
		Cat cat=new Cat() {
//			public Cat(){}  不能有构造方法  只能有一个实例 只用一次
			@Override
			public void eat() {
				System.out.println("eat():继承方式匿名内部类");
			}
		};
		cat.eat();
	}
	//接口方式匿名内部类
	public void print_1(){
		
		eat eat=new eat() {
			
			@Override
			public void eat() {
				System.out.println("eat():接口方式的匿名内部类");
			}
		};
		eat.eat();
	}
	//参数方式的匿名内部类
	public void print_2(eat eat){
		eat.eat();
	}
}
interface eat{  void eat();}
abstract class Cat{ public abstract void eat();}
