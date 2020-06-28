package com.chanpter3.preweb.DOM;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.chanpter3.preweb.Person;

/**
 * java����xml�����ַ�ʽ��sax��dom DOM �� �ĵ�����ģ�� �ص㣺����һ��java�ӿڣ����ڶ��������Ժ�ƽ̨�޹ؽ�xml�ĵ���ʾΪ����
 * ���ڴ��н����ʹ洢xml�ĵ���������������ĵ��Ĳ�ͬ���� �ŵ㣺���������ڴ���ʱ�־õģ���˿��������޸ĺ���¡������������κ�ʱ�����������µ�����
 * APIʹ�������Ƚϼ� �ܽ᣺ �������νṹ ͨ��������һ���԰��ĵ����ص��ڴ��У����Ի�Ƚ�ռ���ڴ棬����������ʣ����������ʺ���WEB������ʹ��
 * 
 * @version:
 * @Description:
 * @author :�⾧
 * @date:2019��9��19�� ����7:27:32
 */
public class DOMDesc {
	public static void main(String[] args) 
			throws ParserConfigurationException, SAXException, IOException {
		// ����һ��dom��������������
		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
		// ͨ��������������������
		DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
		// �����ĵ�
		InputStream is = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("com/chanpter3/preweb/person.xml");
		// �˴�����ɺ� ����xml�ĵ��Ѿ������ص��ڴ��У�����״��ʽ�洢
		Document doc = docBuilder.parse(is);
		// ���ڴ��ж�ȡ����
		NodeList personNodeList = doc.getElementsByTagName("person");
		ArrayList<Person> personList = new ArrayList<>();
		Person person = null;
		for (int i = 0; i < personNodeList.getLength(); i++) {
			Node personNode = personNodeList.item(i);
			person = new Person();
			// ��ȡ�������
			String personid = personNode.getAttributes().getNamedItem("personid").getNodeValue();
			person.setPersonid(personid);

			NodeList childNodes = personNode.getChildNodes();
			for (int j = 0; j < childNodes.getLength(); j++) {
				Node item = childNodes.item(j);
				String nodeName = item.getNodeName();
				if ("name".equals(nodeName)) {
					person.setName(item.getFirstChild().getNodeValue());
				} else if ("tel".equals(nodeName)) {
					person.setTel(item.getFirstChild().getNodeValue());
				} else if ("fax".equals(nodeName)) {
					person.setFax(item.getFirstChild().getNodeValue());
				} else if ("address".equals(nodeName)) {
					person.setAddress(item.getFirstChild().getNodeValue());
				} else if ("email".equals(nodeName)) {
					person.setEmail(item.getFirstChild().getNodeValue());
				}
			}
			personList.add(person);
		}
		System.out.println("���");
		System.out.println(Arrays.toString(personList.toArray()));
	}
}
