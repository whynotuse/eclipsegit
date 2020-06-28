package com.chanpter1.oop;
/**
 * =========================================================
 * 抽象类：用abstract关键字声明的类称为抽象类
 * 			很多具有相同特征和行为的具体对象可以抽象为类
 * 			很多具有相同特征和行为的类可以抽象为一个抽象类
 * 		1可以没有抽象方法
 * 		2非抽象类继承抽象类必需实现所有抽象方法
 * 		3抽象类可以继承抽象类，而且可以不实现抽象方法
 * 		4抽象类可以有非抽象方法和属性
 * 		5抽象类不能被实例化
 * 		6抽象类不能被final修饰
 * 		7抽象类可以有构造方法   初始化参数
 *   总结：抽象和普通类的区别就是可以定义抽象方法 不能创建对象 不能被final修饰
 * ==========================================================
 * 接口：用interface定义的
 * 		       定义全局常量  public static final 
 * 		       抽象方法         public abstract
 * 		一般定义行为 规定规范规则
 *     	1接口是定义一组行为的规范 jdk1.8新特性 接口可以有一个默认的实现方法  public default
 *     	2使用接口，可以让我们的程序更加利于变化
 *     	3接口是面向对象编程体系中的思想精髓之一
 *     	4面向对象设计法则：面向接口编程
 *     	5接口不能有构造方法
 *     	6接口不能被继承
 *     
 *     面向对象设计原则：
 *     		1对修改关闭对扩展开放
 *     		2面向接口编程
 * ========================================================
 * 多态性：对象在运行过程中的多种形态
 * 		抽象是有粒度的    面向抽象或者接口编程  
 * 		1方法的重载和重写就是多态性的表现
 * 		2多个子类就是父类中的多种形态
 * 		3父类引用可以指向子类对象，自动转换
 * 		4子类对象指向父类引用需要强制转换（注意：类型不对会报异常）
 * 		5在实际开发中尽量使用父类引用（利于扩展）
 * =======================================
 * 抽象类应用：模版方法设计模式             算法：广义上有逻辑的都是算法
 * 			定义一个操作中的算法的骨架，将一些可变部分延迟到子类
 * 			模范方法模式使得子类可以不改变一个算法的结构即可重新定义改算法的某些也定的步骤
 * 		例如：制作煎饼果子 有客户的参与（加香肠） 
 * =======================================
 *@author :衡晶
 *@date:2019年9月16日 下午1:24:05
 */
public class Abstracts {
	public static void main(String[] args) {
		templates();
	}

	private static void templates() {
		UserManager user=new UserManager();
		user.action("admin", "update");
		
		StudentManager stu=new StudentManager();
		stu.action("as", "add");
	}
}

abstract class BaseManager{
	public void action(String name,String method){
		//身份校验  通过后具体执行方法的操作延迟到子类
		if("admin".equals(name)){
			excute(method);
		}else{
			System.out.println("您没有权限操作，请联系管理员");
		}
	}

	public abstract void excute(String method); 
}

class UserManager extends BaseManager{
	public void excute(String method){
		if("add".equals(method)){
			System.out.println("user...执行添加方法");
		}else if("update".equals(method)){
			System.out.println("user...执行修改方法");
		}
	}
}

class StudentManager extends BaseManager{

	@Override
	public void excute(String method) {
		if("add".equals(method)){
			System.out.println("执行添加方法stu...");
		}else if("update".equals(method)){
			System.out.println("执行修改方法stu...");
		}
	}
	
}
