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
public class TestDOM4JParserBooks {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		
		try {
			//获取DOM4J的SAX解析器
			SAXReader saxReader = new SAXReader();
			//解析文件
			Document document = saxReader.read(new File("xml/books.xml"));
			//获取根节点
			Element root =document.getRootElement();
			
			List<Element> bookList = root.elements();
			for (int i = 0; i < bookList.size(); i++) {
				Element book = bookList.get(i);
				Attribute isbn = bookList.get(i).attribute(0);
				System.out.println(isbn.getName()+":"+isbn.getValue());
				Element name = book.element("name");
				Element price = book.element("price");
				Element author = book.element("author");
				Element year = book.element("year");
				System.out.println(name.getName()+":"+name.getText());
				System.out.println(price.getName()+":"+price.getText());
				System.out.println(author.getName()+":"+author.getText());
				System.out.println(year.getName()+":"+year.getText());
			}
			
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		System.err.println("耗时： "+(end-start));
	}
}
