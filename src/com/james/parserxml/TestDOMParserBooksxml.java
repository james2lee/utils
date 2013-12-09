package com.james.parserxml;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * 用DOM来解析books.xml文件
 * @author James Lee
 *
 */
public class TestDOMParserBooksxml {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		try {
			//取得DOM工厂
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			//取得DOM解析器
			DocumentBuilder builder = factory.newDocumentBuilder();
			//解析文件
			File file = new File("xml/books.xml");
			Document document = builder.parse(file);
			//取得根节点
			Element root = document.getDocumentElement();
			//取得子节点列表
			NodeList books = root.getChildNodes();
			for (int i = 0; i < books.getLength(); i++) {
				//取得某一个子节点
				Node book = books.item(i);
				if (book.getNodeType() == Node.ELEMENT_NODE) {
					String isbn = book.getAttributes().getNamedItem("isbn").getNodeValue();
					System.err.print(isbn);
				}
				//循环子节点
				for (Node node = book.getFirstChild(); node != null;node = node.getNextSibling()) {
					if (node.getNodeType() == Node.ELEMENT_NODE) {
						//循环name子节点
						if (node.getNodeName().equals("name")) {
							String name = node.getFirstChild().getNodeValue();
							System.err.print("   "+name);
						}
						//循环price子节点
						if (node.getNodeName().equals("price")) {
							String price = node.getFirstChild().getNodeValue();
							System.err.print("   "+price);
						}
						//循环price子节点
						if (node.getNodeName().equals("author")) {
							String author = node.getFirstChild().getNodeValue();
							System.err.print("   "+author);
						}
						//循环price子节点
						if (node.getNodeName().equals("year")) {
							String year = node.getFirstChild().getNodeValue();
							System.err.println("   "+year);
						}
					}
				}
			}
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
