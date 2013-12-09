package com.james.parserxml;

import java.io.File;
import java.io.IOException;
import java.util.Stack;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * 解析personal.xml文件
 * 
 * @author James Lee
 */
public class TestSAXParserBooksxml extends DefaultHandler{
	
	Stack<String> tags = new Stack<String>();
	
	//接收元素中字符数据的通知
	public void characters(char[] ch, int start,int length){
		String tag = tags.peek();
		if (tag.equals("name")) {
			System.out.print("  "+new String(ch,start,length));
		}
		if (tag.equals("price")) {
			System.out.print("  "+new String(ch,start,length));
		}
		if (tag.equals("author")) {
			System.out.print("  "+new String(ch,start,length));
		}
		if (tag.equals("year")) {
			System.out.print("  "+new String(ch,start,length));
		}
	}
	
	//接收文档开始的通知
	public void startElement(String uri,String localName,String qName,Attributes attrs){
		if (qName.equals("book")) {
			System.out.print(attrs.getValue("isbn"));
		}
		tags.push(qName);
	}
	
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		
		try {
			//取得SAX工厂
			SAXParserFactory factory = SAXParserFactory.newInstance();
			//获取SAX解析器
			SAXParser saxParser = factory.newSAXParser();
			//解析文件
			File file = new File("xml/books.xml");
			saxParser.parse(file, new TestSAXParserBooksxml());
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		long end = System.currentTimeMillis();
		System.out.println("");
		System.out.println(end-start);
	}
}
