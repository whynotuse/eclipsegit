package com.test;
/**
 * unicode���룺2�ֽ� java���ô��ֱ��뷽ʽ�����׼��һ�ֱ��룬16���Ʊ�ʾ/u0000����������iso8859-1(1���ֽ���Ҫ����Ӣ����)
 * gbk/gb2312��2���ֽ� ��Ҫ���ڱ�ʾ����
 * utf:���������� �ô����ǽ�ʡ�ռ� 1-6�ֽ� ֧��iso8859-1 ������ҳһ�㶼�ô��ֱ��뷽ʽ ���Ա�ʾ��������
 * �������ԭ��
 *    1������ʹ�õı����뱾�ر��벻ͳһ
 *    2���������У��ͻ��������˱��벻ͳһ��WEB������
 *@version:
 *@Description: 
 *@author :�⾧
 *@date:2019��9��30�� ����11:50:48
 */
public class DecoratorTest {
	
	public static void main(String[] args) {
		
		Drink soya=new SoyaBean();
//		SuggarDecorator suggar=new SuggarDecorator(soya);
		SuggarDecorator suggar=new SuggarDecorator(soya);
//	    EggDecorator egg=new EggDecorator(suggar);
//		BlackBeanDecorator blackBean =new BlackBeanDecorator(egg);
		BlackBeanDecorator blackBean =new BlackBeanDecorator(suggar);
		
		System.out.println("�����������Ϊ��"+blackBean.desciption());
		System.out.println("����۸�"+blackBean.cost()+"Ԫ");
	}
}
