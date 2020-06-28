package com.chanpter1.oop;
/**
 * =========================================================
 * �����ࣺ��abstract�ؼ������������Ϊ������
 * 			�ܶ������ͬ��������Ϊ�ľ��������Գ���Ϊ��
 * 			�ܶ������ͬ��������Ϊ������Գ���Ϊһ��������
 * 		1����û�г��󷽷�
 * 		2�ǳ�����̳г��������ʵ�����г��󷽷�
 * 		3��������Լ̳г����࣬���ҿ��Բ�ʵ�ֳ��󷽷�
 * 		4����������зǳ��󷽷�������
 * 		5�����಻�ܱ�ʵ����
 * 		6�����಻�ܱ�final����
 * 		7����������й��췽��   ��ʼ������
 *   �ܽ᣺�������ͨ���������ǿ��Զ�����󷽷� ���ܴ������� ���ܱ�final����
 * ==========================================================
 * �ӿڣ���interface�����
 * 		       ����ȫ�ֳ���  public static final 
 * 		       ���󷽷�         public abstract
 * 		һ�㶨����Ϊ �涨�淶����
 *     	1�ӿ��Ƕ���һ����Ϊ�Ĺ淶 jdk1.8������ �ӿڿ�����һ��Ĭ�ϵ�ʵ�ַ���  public default
 *     	2ʹ�ýӿڣ����������ǵĳ���������ڱ仯
 *     	3�ӿ��������������ϵ�е�˼�뾫��֮һ
 *     	4���������Ʒ�������ӿڱ��
 *     	5�ӿڲ����й��췽��
 *     	6�ӿڲ��ܱ��̳�
 *     
 *     ����������ԭ��
 *     		1���޸Ĺرն���չ����
 *     		2����ӿڱ��
 * ========================================================
 * ��̬�ԣ����������й����еĶ�����̬
 * 		�����������ȵ�    ���������߽ӿڱ��  
 * 		1���������غ���д���Ƕ�̬�Եı���
 * 		2���������Ǹ����еĶ�����̬
 * 		3�������ÿ���ָ����������Զ�ת��
 * 		4�������ָ����������Ҫǿ��ת����ע�⣺���Ͳ��Իᱨ�쳣��
 * 		5��ʵ�ʿ����о���ʹ�ø������ã�������չ��
 * =======================================
 * ������Ӧ�ã�ģ�淽�����ģʽ             �㷨�����������߼��Ķ����㷨
 * 			����һ�������е��㷨�ĹǼܣ���һЩ�ɱ䲿���ӳٵ�����
 * 			ģ������ģʽʹ��������Բ��ı�һ���㷨�Ľṹ�������¶�����㷨��ĳЩҲ���Ĳ���
 * 		���磺����������� �пͻ��Ĳ��루���㳦�� 
 * =======================================
 *@author :�⾧
 *@date:2019��9��16�� ����1:24:05
 */
public class Abstracts {
	public static void main(String[] args) {
		templates();
	}

	private static void templates() {
		UserManager user=new UserManager();
		user.action("admin", "update");
		
		StudentManager stu=new StudentManager();
		stu.action("as", "add");
	}
}

abstract class BaseManager{
	public void action(String name,String method){
		//���У��  ͨ�������ִ�з����Ĳ����ӳٵ�����
		if("admin".equals(name)){
			excute(method);
		}else{
			System.out.println("��û��Ȩ�޲���������ϵ����Ա");
		}
	}

	public abstract void excute(String method); 
}

class UserManager extends BaseManager{
	public void excute(String method){
		if("add".equals(method)){
			System.out.println("user...ִ����ӷ���");
		}else if("update".equals(method)){
			System.out.println("user...ִ���޸ķ���");
		}
	}
}

class StudentManager extends BaseManager{

	@Override
	public void excute(String method) {
		if("add".equals(method)){
			System.out.println("ִ����ӷ���stu...");
		}else if("update".equals(method)){
			System.out.println("ִ���޸ķ���stu...");
		}
	}
	
}
