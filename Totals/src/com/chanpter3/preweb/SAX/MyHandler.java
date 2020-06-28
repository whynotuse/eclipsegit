package com.chanpter3.preweb.SAX;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.chanpter3.preweb.Person;
/**
 * 
 * SAX�������ص㣺
 * 	1�������¼����� ����һ����ǩ����һ�η���
 * 	2��˳���ȡ �ٶȿ�
 * 	3�����������ȡ��� ����Բ�
 * 	4��sax���ʺ���������Ҫ����ߵ��豸��ʹ�ã�Android������
 *  5������ʱռ�õ��ڴ�С
 * 
 *@version:
 *@Description: 
 *@author :�⾧
 *@date:2019��9��19�� ����7:18:42
 */
public class MyHandler extends DefaultHandler {
	private List<Person> persons = null;
	private Person person;// ��ǰ���ڽ����Ķ���
	private String tag;// ���ڼ�¼��ǰ���ڽ����ı�ǩ��

	// ��ʼ�����ĵ�ʱ����
	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.startDocument();
		persons = new ArrayList<Person>();
		System.out.println("��ʼ�����ĵ�");
	}

	// ����xml�ĵ�����ʱ����
	@Override
	public void endDocument() throws SAXException {
		super.endDocument();
		System.out.println("�ĵ��������");
	}

	// ������ʼԪ��ʱ���� ��ʼ��ǩ
	/**
	 * @param uri
	 *            �����ռ� �����ڰ���
	 * @param localName
	 *            ����ǰ׺�ı�ǩ��
	 * @param qName
	 *            ��ǰ׺�ı�ǩ��
	 * @param attributes
	 *            ��ǰ��ǩ�����Լ���
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);
		if ("person".equals(qName)) {
			person = new Person();
			person.setPersonid(attributes.getValue("personid"));
		}
		tag = qName;
	}

	// ��������Ԫ��ʱ���� ������ǩ
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(uri, localName, qName);
		if("person".equals(qName)){
			persons.add(person);
		}
		tag = null;
	}

	// �����ı�����ʱ����
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		super.characters(ch, start, length);
		if (tag != null) {
			if ("name".equals(tag)) {
				person.setName(new String(ch, start, length));
			} else if ("address".equals(tag)) {
				person.setAddress(new String(ch, start, length));
			} else if ("fax".equals(tag)) {
				person.setFax(new String(ch, start, length));
			} else if ("email".equals(tag)) {
				person.setEmail(new String(ch, start, length));
			} else if ("tel".equals(tag)) {
				person.setTel(new String(ch, start, length));
			}
		}
	}
	
	public List<Person> getPersons(){
		return persons;
	}

}
