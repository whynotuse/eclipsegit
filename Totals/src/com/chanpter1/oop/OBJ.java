package com.chanpter1.oop;
/**
 * ======================================
 * Object�ࣺ�������ֱ�ӻ��߼�Ӹ���
 * 			toString();�����������������Ϣ   ������Ӧ����д  �����Ե�����
 * 			equals();�����Ƚ϶����Ƿ���ͬ �Լ�����  ���轨����hashCode();һ����д
 * 			finalize();�ͷ���Դʱ���õ� ��������д  ������������ȷ�������ڸö���ĸ�������ʱ�ɶ�����������������ô˷��� �˽�
 * 			getClass();���ض��������ʱ��  nativeϵͳ�ײ㷽��  ����Ϣ���� class�ֽ������ Class���͵Ķ���
 * ======================================
 * �򵥹���ģʽ����һ���������������������һ�ֲ�Ʒ���ʵ�����򵥹���ģʽ�ǹ���ģʽ���������ʹ�õ�ģʽ
 * 			����
 * ======================================
 * ��̬����ģʽ��Ϊ���������ṩһ�ִ����Կ��ƶԸö���ķ��ʡ�  Ҳ���Ƿ��ʶ���ʱ����һ���̶ȵļ���ԣ����Ը��Ӷ�����;
 * 
 * 			����ģ�淽��ģʽ  ����ע�㲻һ��   �Ǽ�   �����ǹ�ע������ʵ����֮ǰ��֮����߹����еĿ���
 * ===================================================
 * ������ģʽ��ʹ��ԭ�����ڽӿڲ����ݶ�����һ�����������һ����  ���ȵİ취
 * 
 *@version:
 *@Description: 
 *@author :�⾧
 *@date:2019��9��16�� ����3:25:46
 */
public class OBJ {
	public static void main(String[] args) {
//		factoryDemo();
		
	//	staticProxy();
		
		adapter();
		
	}

	private static void adapter() {
		PowerAImpl pa = new PowerAImpl();
		work(pa);
		PowerB pb = new PowerBImpl();
		//work(pb);
		work(new Adapter(pb));
		
	}
	public static void work(PowerA pa){
		pa.insert();
	}

	private static void staticProxy() {
		//��¼ִ�е�ʱ��
		ActionProxy aproxy=new ActionProxy(new Person());
		aproxy.doAction();
		
	}
	
	

	private static void factoryDemo() {
		//ʹ���ߺͱ�ʹ��������֮�� ��� ����������  ԭ�򣺵���ʹ���߷����仯ʱ����Ӱ��ʹ����
		//ʹ�ù���ģʽ����������֮�������
		/*Product phone  = new phone();
		Product computer = new computer();*/
		Product phone = ProductFactory.getProduct("phone");
		Product computer = ProductFactory.getProduct("computer");
		
		if (null != phone)
			phone.work();
		if (null != computer)
			computer.work();
	}
}
//================================������ģʽ===========��׿���õĶ�====================================
interface PowerA{ void insert();}
interface PowerB{ void connect();}
class PowerAImpl implements PowerA{

	@Override
	public void insert() {
		System.out.println("powera");
	}}
class PowerBImpl implements PowerB{

	@Override
	public void connect() {
		System.out.println("powerb");
	}}

class Adapter implements PowerA{
	private PowerB pb;
	public Adapter(PowerB pb){this.pb=pb;}
	@Override
	public void insert() {
		pb.connect();
	}
	
}
//��������������ת�ӵķ�ʽ


//============================�򵥹���ģʽ==============================================
//������
class ProductFactory{
	//����ֵ�ǽӿ�
	public static Product getProduct(String name){
//		if("computer".equals(name)){
//			return new computer();
//		}else if("phone".equals(name)){
//			return new phone();
//		}
//		return null;
		switch (name) {
		
		case "computer":
			return new computer();
		case "phone":
			return new phone();
		default:
			return null;
		}
	}
}
interface Product{
	void work();
}
class phone implements Product{

	@Override
	public void work() {
		System.out.println("����ũҩ");
	}}
class computer implements Product{

	@Override
	public void work() {
		System.out.println("ߣ��ߣ");
	}}

//===============================��̬����ģʽ==========================================
class ActionProxy implements Action{
	private Action target;//���������
	public ActionProxy(Action target){this.target=target;}
	@Override
	public void doAction() {
		long startTime =System.currentTimeMillis();
		
		target.doAction();//ִ��������ҵ��
		
		long endTime=System.currentTimeMillis();
		System.out.println(endTime-startTime);
	}
	
}

interface Action{
	void doAction();
}

class Person implements Action{

	@Override
	public void doAction() {
		try {
			Thread.sleep(2200);
			for(int i=1;i<1000;i++){System.out.println(i);}
			System.out.println("11·�ȶ��Ż�");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
