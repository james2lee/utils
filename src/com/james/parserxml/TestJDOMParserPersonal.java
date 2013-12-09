package com.james.parserxml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;

/**
 * 用JDOM的SAX方式解析XML文档
 * @author James Lee
 *
 */
public class TestJDOMParserPersonal {

	public static void main(String[] args) {

		long start = System.currentTimeMillis();

			try {
				//获取JDOM解析器
				SAXBuilder builder = new SAXBuilder();
				//解析文件
				File file = new File("xml/personal.xml");
				Document document = builder.build(file);
				
				//写入XML文件
				FileOutputStream fileOutputStream = new FileOutputStream(new File("D:/bbb.xml"));
				XMLOutputter xmlOutputter = new XMLOutputter();
				xmlOutputter.output(document, fileOutputStream);
				fileOutputStream.close();
				
				//获取根节点
				Element root = document.getRootElement();
				//获取子节点列表
				List<Element> personnel = root.getChildren();
				//循环遍历子节点
				for (int i = 0; i < personnel.size(); i++) {
					//获取某一个子节点
					Element person = personnel.get(i);
					//获取得属性值
					String id = person.getAttributes().get(0).getValue();
					System.out.print("id: " + id);

					Element name = person.getChild("name");
					List<Element> nameList = name.getChildren();
					for (int j = 0; j < nameList.size(); j++) {
						Element name1 = nameList.get(j);
						System.out.print("   " + name1.getName() + ": " + name1.getValue());
					}

					Element email = person.getChild("email");
					System.out.print("    " + email.getName() + ": " + email.getValue());

					Element link = person.getChild("link");
					Attribute attribute = link.getAttributes().get(0);
					System.out.print("    " + attribute.getName() + ": " + attribute.getValue());
					System.out.println("");
				}
			} catch (JDOMException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		long end = System.currentTimeMillis();
		System.out.println("耗时： " + (end - start));
	}
}
