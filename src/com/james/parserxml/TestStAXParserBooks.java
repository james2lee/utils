package com.james.parserxml;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class TestStAXParserBooks {
	public static void main(String[] args) {
		try {
			XMLInputFactory factory = XMLInputFactory.newFactory();
			XMLStreamReader reader = factory.createXMLStreamReader(new FileReader("xml/books.xml"));
			int event = reader.getEventType();
			while (true) {
				switch (event) {
					case XMLStreamConstants.START_DOCUMENT:
						break;
					case XMLStreamConstants.START_ELEMENT:
						//获取isbn节点
						for (int i = 0, n = reader.getAttributeCount(); i < n; i++) {
							System.err.println(">>>"+reader.getAttributeValue(i));
						}
						break;
						//读取节点值
					case XMLStreamConstants.CHARACTERS:
						if (reader.isWhiteSpace()) {
							break;
						}
						System.out.println(reader.getText());
						break;
					case XMLStreamConstants.END_ELEMENT:
						break;
					case XMLStreamConstants.END_DOCUMENT:
						break;
				}
				if (!reader.hasNext()) {
					break;
				}
				event = reader.next();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (FactoryConfigurationError e) {
			e.printStackTrace();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
	}
}
