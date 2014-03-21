package com.screw;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXScrew extends DefaultHandler implements Screw {

	private Order order;
	private String preNode;

	@Override
	public void startDocument() throws SAXException {
		
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		if("id".equals(qName)){
			order = new Order();
		}
		
		preNode = qName;
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		preNode = null;
	}
	
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		if(order != null){
			String content = new String(ch,start,length);
			if("id".equals(preNode)){
				order.setId(Integer.parseInt(content));
			}
			if("price".equals(preNode)){
				order.setAddress(content);
			}
			if("address".equals(preNode)){
				order.setAddress(content);
			}
		}
	}

	@Override
	public Object fromXML(String xml) {
		InputStream input = this.getClass().getClassLoader().getResourceAsStream(xml);
		SAXParserFactory factory = SAXParserFactory.newInstance();  
        try {
			SAXParser parser = factory.newSAXParser();
			parser.parse(input, this);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return order;
	}
}
