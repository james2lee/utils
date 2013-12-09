package com.james.parserxml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;

public class TestJDOMParserBooks {

	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		try {
			//获取JDOM解析器
			SAXBuilder builder = new SAXBuilder();
			//解析文件
			File file = new File("xml/books.xml");
			Document document = builder.build(file);
			
			//写入XML文件
			FileOutputStream fileOutputStream = new FileOutputStream(new File("D:/aaa.xml"));
			XMLOutputter xmlOutputter = new XMLOutputter();
			xmlOutputter.output(document, fileOutputStream);
			fileOutputStream.close();
			
			
			//获取根节点
			Element root = document.getRootElement();
			//获取子节点列表
			List<Element> books = root.getChildren();
			//循环遍历子节点
			for (int i = 0; i < books.size();i++) {
				//获取某一个子节点
				Element book = books.get(i);
				//获取得属性值
				String isbn = book.getAttributeValue("isbn");
				System.out.print("isbn: "+isbn);
				List<Element> childrenList = book.getChildren();
				for (Element element : childrenList) {
					System.out.print("   "+element.getName()+": ");
					System.out.print(element.getText());
				}
				System.out.println("");
			}
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		System.out.println("耗时： "+(end-start));
	}
}
