package com.test;

public class BlackBeanDecorator extends Decorator{

	public BlackBeanDecorator(Drink drink) {
		super(drink);
	}
	@Override
	public float cost() {
		return super.cost()+ 5f;
	}
	@Override
	public String desciption() {
		return super.desciption()+"+ºÚ¶¹";
	}
	

}
