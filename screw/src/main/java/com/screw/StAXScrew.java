package com.screw;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class StAXScrew extends AbstractScrew {

    @Override
    public <T> T fromXML(String xml, Class<T> clazz) {
        Map<String, Method> setterMethodMap = setterCache.get(clazz);
        if (setterMethodMap == null) {
            addSetterMethod(clazz);
            setterMethodMap = setterCache.get(clazz);
        }
        
        InputStream inputStream = new ByteArrayInputStream(xml.getBytes());
        XMLInputFactory factory = XMLInputFactory.newInstance();
        try {
            XMLStreamReader reader = factory.createXMLStreamReader(inputStream);
            
            T obj = clazz.newInstance();
            while(reader.hasNext()){
                int event = reader.next();
                // 如果是元素的开始
                if(event == XMLStreamConstants.START_ELEMENT){
                    String element = reader.getLocalName();
                    Method method = setterMethodMap.get(element);
                    if(method != null){
                        method.invoke(obj, reader.getElementText());
                    }
                }
            }
            return obj;
        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }
}
