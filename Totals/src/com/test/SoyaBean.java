package com.test;
/**
 * ��װ���ߵ�ʵ����
 *@version:
 *@Description: 
 *@author :�⾧
 *@date:2019��9��30�� ����11:28:19
 */
public class SoyaBean implements Drink{

	@Override
	public float cost() {
		return 10f;
	}

	@Override
	public String desciption() {
		return "����";
	}

}
