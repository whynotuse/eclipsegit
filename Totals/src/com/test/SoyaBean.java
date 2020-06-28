package com.test;
/**
 * 被装饰者的实现类
 *@version:
 *@Description: 
 *@author :衡晶
 *@date:2019年9月30日 上午11:28:19
 */
public class SoyaBean implements Drink{

	@Override
	public float cost() {
		return 10f;
	}

	@Override
	public String desciption() {
		return "豆浆";
	}

}
