package com.test;
/**
 * 装饰者基类
 *@version:
 *@Description: 
 *@author :衡晶
 *@date:2019年9月30日 上午11:14:04
 */
public abstract class Decorator implements Drink{
	//被装饰的引用
	private Drink drink;
	
	
	public Decorator(Drink drink) {
		this.drink = drink;
	}

	@Override
	public float cost() {
		return drink.cost();
	}

	@Override
	public String desciption() {
		// TODO Auto-generated method stub
		return drink.desciption();
	}

}
