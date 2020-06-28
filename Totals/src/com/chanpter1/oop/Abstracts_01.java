package com.chanpter1.oop;

import java.io.FileInputStream;

/**
 * ==========================================
 * ����ģʽ������һϵ���㷨����ÿһ���㷨��װ���������໥�滻ʹ�ã�����ģʽ���㷨������ʹ�����Ŀͻ�Ӧ�ö�����
 * 			dao����ʹ�ò���ģʽ��
 * 		1����ӿڱ��
 * 		2��װ�仯 �ɱ��
 * 		3������� ���ü̳�
 * ===========================================
 * 			
 * 
 * 
 * 
 * @version:
 * @Description:
 * @author :�⾧
 * @date:2019��9��16�� ����2:47:59
 */
public class Abstracts_01 {

	public static void main(String[] args) {
		strategy();
	}
	/**
	 * ����ģʽ
	 * @Description:
	 */
	private static void strategy() {
		BaseService user=new UserService();
//		user.setISave(new NetSave());//���浽����
//		user.setISave(new FileSave());//���浽�����ļ�
		user.setISave(new DataSave());//���浽���ݿ�
		user.add("����");
	}
}
class UserService extends BaseService{}
abstract class BaseService {

	private iSave iSave;//�󶨽ӿ�  ��Ͻӿ�  ����ӿڱ��

	public void setISave(iSave iSave) {
		this.iSave = iSave;
	}
	public void add(String data){
		System.out.println("������ݺϷ���......");
		iSave.save(data);
		System.out.println("����ɹ�");
	}
}

//�ѿɱ���Ϊ�������  ����һϵ���㷨  �ӿڵ�Ӧ��
interface iSave {
	public abstract void save(String data);
}

class FileSave implements iSave {
	@Override
	public void save(String data) {
		System.out.println("���浽�����ļ���");
	}
}
class DataSave implements iSave{

	@Override
	public void save(String data) {
		System.out.println("���浽���ݿ�");
	}}

class NetSave implements iSave {
	@Override
	public void save(String data) {
		System.out.println("���浽����");
	}
}