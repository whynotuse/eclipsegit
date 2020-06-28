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
 * java解析xml的两种方式：sax和dom DOM ： 文档对象模型 特点：定义一组java接口，基于对象，与语言和平台无关将xml文档表示为树，
 * 在内存中解析和存储xml文档，允许随机访问文档的不同部分 优点：由于树在内存中时持久的，因此可以任意修改后更新。它还可以在任何时候在树中上下导航，
 * API使用起来比较简单 总结： 基于树形结构 通过解析器一次性把文档加载到内存中，所以会比较占用内存，可以随机访问，更加灵活，更适合在WEB开发中使用
 * 
 * @version:
 * @Description:
 * @author :衡晶
 * @date:2019年9月19日 下午7:27:32
 */
public class DOMDesc {
	public static void main(String[] args) 
			throws ParserConfigurationException, SAXException, IOException {
		// 创建一个dom解析器工厂对象
		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
		// 通过工厂创建解析器对象
		DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
		// 解析文档
		InputStream is = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("com/chanpter3/preweb/person.xml");
		// 此代码完成后 整个xml文档已经被加载到内存中，以树状形式存储
		Document doc = docBuilder.parse(is);
		// 从内存中读取数据
		NodeList personNodeList = doc.getElementsByTagName("person");
		ArrayList<Person> personList = new ArrayList<>();
		Person person = null;
		for (int i = 0; i < personNodeList.getLength(); i++) {
			Node personNode = personNodeList.item(i);
			person = new Person();
			// 获取结点属性
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
		System.out.println("结果");
		System.out.println(Arrays.toString(personList.toArray()));
	}
}
