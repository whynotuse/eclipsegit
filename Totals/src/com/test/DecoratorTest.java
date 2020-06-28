package com.test;
/**
 * unicode编码：2字节 java采用此种编码方式，最标准的一种编码，16进制表示/u0000，但不兼容iso8859-1(1个字节主要用再英文上)
 * gbk/gb2312：2个字节 主要用于表示中文
 * utf:不定长编码 好处就是节省空间 1-6字节 支持iso8859-1 中文网页一般都用此种编码方式 可以表示所有文字
 * 造成乱码原因：
 *    1：程序使用的编码与本地编码不统一
 *    2：在网络中，客户端与服务端编码不统一（WEB开发）
 *@version:
 *@Description: 
 *@author :衡晶
 *@date:2019年9月30日 上午11:50:48
 */
public class DecoratorTest {
	
	public static void main(String[] args) {
		
		Drink soya=new SoyaBean();
//		SuggarDecorator suggar=new SuggarDecorator(soya);
		SuggarDecorator suggar=new SuggarDecorator(soya);
//	    EggDecorator egg=new EggDecorator(suggar);
//		BlackBeanDecorator blackBean =new BlackBeanDecorator(egg);
		BlackBeanDecorator blackBean =new BlackBeanDecorator(suggar);
		
		System.out.println("您购买的种类为："+blackBean.desciption());
		System.out.println("计算价格："+blackBean.cost()+"元");
	}
}
