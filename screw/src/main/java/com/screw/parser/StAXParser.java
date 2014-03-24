package com.screw.parser;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Map;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.screw.common.utils.ConvertUtils;
import com.screw.exception.ScrewException;

public class StAXParser extends AbstractParser {

    private static final Logger logger = LoggerFactory.getLogger(StAXParser.class);
    
    public void parse(InputStream inputStream, Object obj){
        if(inputStream == null){
            logger.error("inputStream can not be null");
            throw new ScrewException();
        }
        if(obj == null){
            logger.error("obj can not be null");
            throw new ScrewException();
        }
        
        XMLInputFactory factory = XMLInputFactory.newInstance();
        try {
            XMLStreamReader reader = factory.createXMLStreamReader(inputStream);

            Class<?> clazz = obj.getClass();
            Map<String, Method> setterMethodMap = setterPool.get(clazz);
            if (setterMethodMap == null) {
                addSetterMethod(clazz);
                setterMethodMap = setterPool.get(clazz);
            }
            
            while (reader.hasNext()) {
                int event = reader.next();
                if (event == XMLStreamConstants.START_ELEMENT) {
                    String element = reader.getLocalName();
                    Method method = setterMethodMap.get(element);
                    if (method != null) {
                        String content = reader.getElementText();
                        logger.debug("name : " + element + " , content : "+ content);
                        
                        Type[] types = method.getGenericParameterTypes();
                        
                        method.invoke(obj, ConvertUtils.convert(content, types[0]));
                    }
                }
            }
        } catch (Exception e) {
            logger.error("Parse error : Class = " + obj.getClass().getName(), e);
            throw new ScrewException();
        }
    }
}
