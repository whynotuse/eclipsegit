package com.test;
/**
 * װ���ߵ�ʵ����
 *@version:
 *@Description: 
 *@author :�⾧
 *@date:2019��9��30�� ����11:30:35
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
		return super.desciption()+"+����";
	}
	

}
