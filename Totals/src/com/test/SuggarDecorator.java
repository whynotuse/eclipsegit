package com.test;

public class SuggarDecorator extends Decorator{

	public SuggarDecorator(Drink drink) {
		super(drink);
	}
	@Override
	public float cost() {
		return super.cost()+ 0.5f;
	}
	@Override
	public String desciption() {
		return super.desciption()+"+лг";
	}
	

}
