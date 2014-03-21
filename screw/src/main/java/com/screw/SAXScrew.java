package com.screw;

import java.io.InputStream;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXScrew extends DefaultHandler implements Screw {

    private List<Book> books = null;
    
    public List<Book> getBooks(InputStream xmlStream) throws Exception{  
        SAXParserFactory factory = SAXParserFactory.newInstance();  
        SAXParser parser = factory.newSAXParser();  
        SAXScrew handler = new SAXScrew();  
        parser.parse(xmlStream, handler);  
        return handler.getBooks();  
    }
    
    public List<Book> getBooks(){  
        return books;  
    } 
    
    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
    }
    
    @Override
    public void startElement(String uri, String localName, String qName,
            Attributes attributes) throws SAXException {
        System.out.println("uri的属性值：" + uri);  
        System.out.println("localName的属性值：" + localName);  
        System.out.println("qName的属性值：" + qName);
        super.startElement(uri, localName, qName, attributes);
    }
    
    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        super.endElement(uri, localName, qName);
    }
    
    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        super.characters(ch, start, length);
    }

    @Override
    public Object fromXML(String xml) {
        // TODO Auto-generated method stub
        return null;
    }
}
