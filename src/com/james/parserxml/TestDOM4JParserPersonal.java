package com.james.parserxml;

import java.io.File;
import java.util.List;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * DOM4J解析XML
 * @author James Lee
 *
 */
public class TestDOM4JParserPersonal {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		
		try {
			//获取DOM4J的SAX解析器
			SAXReader saxReader = new SAXReader();
			//解析文件
			Document document = saxReader.read(new File("xml/personal.xml"));
			//获取根节点
			Element root =document.getRootElement();
			
			List<Element> personList = root.elements();
			//循环遍历子节点
			for (int i = 0; i < personList.size(); i++) {
				//获取子节点的属性
				Attribute id = personList.get(i).attribute(0);
				System.out.println(id.getName()+":	"+id.getText());
				Element person = personList.get(i);
				//获取name节点
				Element name = person.element("name");
				//循环遍历name节点的子节点
				List<Element> nameList = name.elements();
				for (Element element : nameList) {
					System.out.println(name.getName()+"."+element.getName()+":  "+element.getText());
				}
				Element email = person.element("email");
				System.out.println(email.getName()+":	"+email.getText());
				List<Attribute> linkAttributes = person.element("link").attributes();
				for (Attribute attribute : linkAttributes) {
					System.out.println(attribute.getName()+":	"+attribute.getText());
				}
				System.out.println("-----------------------------------------------------------");
				
			}
			
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		System.err.println("耗时： "+(end-start));
	}
}
