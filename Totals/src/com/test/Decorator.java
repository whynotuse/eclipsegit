package com.test;
/**
 * װ���߻���
 *@version:
 *@Description: 
 *@author :�⾧
 *@date:2019��9��30�� ����11:14:04
 */
public abstract class Decorator implements Drink{
	//��װ�ε�����
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
