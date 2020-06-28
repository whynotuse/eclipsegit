package com.chanpter3.preweb.SAX;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import com.chanpter3.preweb.Person;

/**
 * xml����
 * 		��;��     1�䵱��ʾ���ݣ���xml����ʾ�㣩
 * 				2 �洢���ݣ��洢�㣩�Ĺ��� 
 * 				3 ��xml�������ݣ�������ϰ��������ϵͳ���ಿ��֮��Ĵ��ݣ��������ݵ�һ�ָ�ʽ��
 * 		��ĳ�ֽǶ�������xml�����ݷ�װ����Ϣ���ݼ���  ���߽϶�
 * SAX:�����¼���API  simple API for xml
 * 		��Ҫ�����ִ����¼��Ľӿ� ʵ����ֻҪ�̳�defaulthandler��Ϳ��� �ṩĬ��ʵ�� �������ķ�ʽ
 * 		����sax��������������
 * 		ʹ�ý�������������������ʵ��
 * 		����sax������Ҫʹ�õ�ʱ���������
 * 		��ʼ����
 *@version:
 *@Description: 
 *@author :�⾧
 *@date:2019��9��19�� ����6:11:14
 */
public class XMLDesc {
	public static void main(String[] args) {
		test1();
	}

	private static void test1() {
		//1����һ��sax������������
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		try {
			//2����������
			SAXParser Parser = saxParserFactory.newSAXParser();
			//3�������ݴ����� ��Ҫ�̳�defaulthandler
			MyHandler myHandler = new MyHandler(); 
			//4��ʼ����
			InputStream is=Thread.currentThread().getContextClassLoader().getResourceAsStream("com/chanpter3/preweb/person.xml");
			Parser.parse(is, myHandler);
			List<Person> persons = myHandler.getPersons();
			for (Person person : persons) {
				System.out.println(person);
			}
			
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
