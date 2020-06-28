package com.chanpter1.oop;
/**
 * ======================================
 * Object类：所有类的直接或者间接父类
 * 			toString();用来描述本类对象信息   所有类应当重写  对属性的描述
 * 			equals();用来比较对象是否相同 自己定义  必需建议与hashCode();一起重写
 * 			finalize();释放资源时调用的 不建议重写  当垃圾回收器确定不存在该对象的更多引用时由对象的垃圾回收器调用此方法 了解
 * 			getClass();返回对象的运行时类  native系统底层方法  类信息对象 class字节码对象 Class类型的对象
 * ======================================
 * 简单工厂模式：有一个工厂对象决定创建出哪一种产品类的实例，简单工厂模式是工厂模式家族中最简单使用的模式
 * 			解耦
 * ======================================
 * 静态代理模式：为其他对象提供一种代理以控制对该对象的访问。  也就是访问对象时引入一定程度的间接性，可以附加多种用途
 * 
 * 			类似模版方法模式  但关注点不一样   骨架   代理是关注访问真实对象之前和之后或者过程中的控制
 * ===================================================
 * 适配器模式：使得原本由于接口不兼容而不能一起工作的类可以一起工作  补救的办法
 * 
 *@version:
 *@Description: 
 *@author :衡晶
 *@date:2019年9月16日 下午3:25:46
 */
public class OBJ {
	public static void main(String[] args) {
//		factoryDemo();
		
	//	staticProxy();
		
		adapter();
		
	}

	private static void adapter() {
		PowerAImpl pa = new PowerAImpl();
		work(pa);
		PowerB pb = new PowerBImpl();
		//work(pb);
		work(new Adapter(pb));
		
	}
	public static void work(PowerA pa){
		pa.insert();
	}

	private static void staticProxy() {
		//记录执行的时间
		ActionProxy aproxy=new ActionProxy(new Person());
		aproxy.doAction();
		
	}
	
	

	private static void factoryDemo() {
		//使用者和被使用者两者之间 耦合 产生了依赖  原因：当被使用者发生变化时，会影响使用者
		//使用工厂模式来降低两者之间的依赖
		/*Product phone  = new phone();
		Product computer = new computer();*/
		Product phone = ProductFactory.getProduct("phone");
		Product computer = ProductFactory.getProduct("computer");
		
		if (null != phone)
			phone.work();
		if (null != computer)
			computer.work();
	}
}
//================================适配器模式===========安卓中用的多====================================
interface PowerA{ void insert();}
interface PowerB{ void connect();}
class PowerAImpl implements PowerA{

	@Override
	public void insert() {
		System.out.println("powera");
	}}
class PowerBImpl implements PowerB{

	@Override
	public void connect() {
		System.out.println("powerb");
	}}

class Adapter implements PowerA{
	private PowerB pb;
	public Adapter(PowerB pb){this.pb=pb;}
	@Override
	public void insert() {
		pb.connect();
	}
	
}
//适配器就是用来转接的方式


//============================简单工厂模式==============================================
//工厂类
class ProductFactory{
	//返回值是接口
	public static Product getProduct(String name){
//		if("computer".equals(name)){
//			return new computer();
//		}else if("phone".equals(name)){
//			return new phone();
//		}
//		return null;
		switch (name) {
		
		case "computer":
			return new computer();
		case "phone":
			return new phone();
		default:
			return null;
		}
	}
}
interface Product{
	void work();
}
class phone implements Product{

	@Override
	public void work() {
		System.out.println("王者农药");
	}}
class computer implements Product{

	@Override
	public void work() {
		System.out.println("撸啊撸");
	}}

//===============================静态代理模式==========================================
class ActionProxy implements Action{
	private Action target;//被代理对象
	public ActionProxy(Action target){this.target=target;}
	@Override
	public void doAction() {
		long startTime =System.currentTimeMillis();
		
		target.doAction();//执行真正的业务
		
		long endTime=System.currentTimeMillis();
		System.out.println(endTime-startTime);
	}
	
}

interface Action{
	void doAction();
}

class Person implements Action{

	@Override
	public void doAction() {
		try {
			Thread.sleep(2200);
			for(int i=1;i<1000;i++){System.out.println(i);}
			System.out.println("11路腿儿着回");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
