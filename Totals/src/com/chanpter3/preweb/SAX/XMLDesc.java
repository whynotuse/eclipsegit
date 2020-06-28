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
 * xml技术
 * 		用途：     1充当显示数据（用xml做显示层）
 * 				2 存储数据（存储层）的功能 
 * 				3 以xml描述数据，并在练习服务器与系统其余部分之间的传递（传输数据的一种格式）
 * 		从某种角度来讲，xml是数据封装和消息传递技术  后者较多
 * SAX:基于事件的API  simple API for xml
 * 		主要有四种处理事件的接口 实际上只要继承defaulthandler类就可以 提供默认实现 适配器的方式
 * 		创建sax解析器工厂对象
 * 		使用解析器工厂创建解析器实例
 * 		创建sax解析器要使用的时间监听对象
 * 		开始解析
 *@version:
 *@Description: 
 *@author :衡晶
 *@date:2019年9月19日 下午6:11:14
 */
public class XMLDesc {
	public static void main(String[] args) {
		test1();
	}

	private static void test1() {
		//1创建一个sax解析工厂对象
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		try {
			//2创建解析器
			SAXParser Parser = saxParserFactory.newSAXParser();
			//3创建数据处理器 需要继承defaulthandler
			MyHandler myHandler = new MyHandler(); 
			//4开始解析
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
