package com.test;
/**
 * 装饰者的实现类
 *@version:
 *@Description: 
 *@author :衡晶
 *@date:2019年9月30日 上午11:30:35
 */
public class EggDecorator extends Decorator{

	public EggDecorator(Drink drink) {
		super(drink);
	}
	@Override
	public float cost() {
		return super.cost()+ 5f;
	}
	@Override
	public String desciption() {
		return super.desciption()+"+鸡蛋";
	}
	

}
