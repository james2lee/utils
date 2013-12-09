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
 * 用DOM来解析personal.xml文件
 * 
 * @author James Lee
 */
public class TestDOMParserPersonalxml {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		try {
			//取得DOM工厂
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			//取得DOM解析器
			DocumentBuilder builder = factory.newDocumentBuilder();
			//解析文件
			File file = new File("xml/personal.xml");
			Document document = builder.parse(file);
			//取得根节点
			Element root = document.getDocumentElement();
			//取得子节点列表
			NodeList personals = root.getChildNodes();
			for (int i = 0; i < personals.getLength(); i++) {
				//取得某一个子节点
				Node personal = personals.item(i);
				if (personal.getNodeType() == Node.ELEMENT_NODE) {
					String person = personal.getAttributes().getNamedItem("id").getNodeValue();
					System.err.print("id: "+person);
				}
				//循环子节点
				for (Node node = personal.getFirstChild(); node != null; node = node.getNextSibling()) {
					if (node.getNodeType() == Node.ELEMENT_NODE) {
						//循环name子节点
						if (node.getNodeName().equals("name")) {
							NodeList nList = node.getChildNodes();
							//循环name节点的子节点
							for (int j = 0; j < nList.getLength(); j++) {
								//取得子节点列表
								Node childNode = nList.item(j);
								if (childNode.getNodeName().equals("family")) {
									String family = childNode.getFirstChild().getNodeValue();
									System.out.print("     family: "+ family);
								}
								if (childNode.getNodeName().equals("given")) {
									String given = childNode.getFirstChild().getNodeValue();
									System.out.print("  given: "+ given);
								}
							}
						}
						//循环email子节点
						if (node.getNodeName().equals("email")) {
							String email = node.getFirstChild().getNodeValue();
							System.err.print("   email: " + email);
						}
						//循环link子节点
						if (node.getNodeName().equals("link")) {
							System.err.println("   link: " + node.getAttributes().item(0).getNodeName() + "=" + node.getAttributes().item(0).getNodeValue());
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
		System.out.println(end - start);
	}
}
