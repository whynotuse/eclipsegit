package com.chanpter1.oop;

import java.io.FileInputStream;

/**
 * ==========================================
 * 策略模式：定义一系列算法，将每一种算法封装起来可以相互替换使用，策略模式让算法独立于使用它的客户应用而独立
 * 			dao就是使用策略模式的
 * 		1面向接口编程
 * 		2封装变化 可变的
 * 		3多用组合 少用继承
 * ===========================================
 * 			
 * 
 * 
 * 
 * @version:
 * @Description:
 * @author :衡晶
 * @date:2019年9月16日 下午2:47:59
 */
public class Abstracts_01 {

	public static void main(String[] args) {
		strategy();
	}
	/**
	 * 策略模式
	 * @Description:
	 */
	private static void strategy() {
		BaseService user=new UserService();
//		user.setISave(new NetSave());//保存到网络
//		user.setISave(new FileSave());//保存到本地文件
		user.setISave(new DataSave());//保存到数据库
		user.add("张三");
	}
}
class UserService extends BaseService{}
abstract class BaseService {

	private iSave iSave;//绑定接口  组合接口  面向接口编程

	public void setISave(iSave iSave) {
		this.iSave = iSave;
	}
	public void add(String data){
		System.out.println("检查数据合法性......");
		iSave.save(data);
		System.out.println("保存成功");
	}
}

//把可变行为抽象出来  定义一系列算法  接口的应用
interface iSave {
	public abstract void save(String data);
}

class FileSave implements iSave {
	@Override
	public void save(String data) {
		System.out.println("保存到本地文件中");
	}
}
class DataSave implements iSave{

	@Override
	public void save(String data) {
		System.out.println("保存到数据库");
	}}

class NetSave implements iSave {
	@Override
	public void save(String data) {
		System.out.println("保存到网络");
	}
}