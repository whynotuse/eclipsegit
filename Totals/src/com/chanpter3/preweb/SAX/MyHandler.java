package com.chanpter3.preweb.SAX;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.chanpter3.preweb.Person;
/**
 * 
 * SAX解析的特点：
 * 	1，基于事件驱动 读到一个标签调用一次方法
 * 	2：顺序读取 速度快
 * 	3：不能任意读取结点 灵活性差
 * 	4：sax更适合于在性能要求更高的设备上使用（Android开发）
 *  5：解析时占用的内存小
 * 
 *@version:
 *@Description: 
 *@author :衡晶
 *@date:2019年9月19日 下午7:18:42
 */
public class MyHandler extends DefaultHandler {
	private List<Person> persons = null;
	private Person person;// 当前正在解析的对象
	private String tag;// 用于记录当前正在解析的标签名

	// 开始解析文档时调用
	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.startDocument();
		persons = new ArrayList<Person>();
		System.out.println("开始解析文档");
	}

	// 解析xml文档结束时调用
	@Override
	public void endDocument() throws SAXException {
		super.endDocument();
		System.out.println("文档解析完成");
	}

	// 解析开始元素时调用 开始标签
	/**
	 * @param uri
	 *            命名空间 类似于包名
	 * @param localName
	 *            不带前缀的标签名
	 * @param qName
	 *            带前缀的标签名
	 * @param attributes
	 *            当前标签的属性集合
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

	// 解析结束元素时调用 结束标签
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(uri, localName, qName);
		if("person".equals(qName)){
			persons.add(person);
		}
		tag = null;
	}

	// 解析文本内容时调用
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
