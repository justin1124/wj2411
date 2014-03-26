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

import com.screw.common.CachePool;
import com.screw.common.utils.Assert;
import com.screw.common.utils.ConvertUtils;
import com.screw.common.utils.ReflectUtils;
import com.screw.exception.ScrewException;

public class StAXParser extends AbstractParser {

    private static final Logger logger = LoggerFactory.getLogger(StAXParser.class);
    
    public void parse(InputStream inputStream, Object obj){
        Assert.notNull(inputStream, "InputStream must not be null");
        Assert.notNull(obj, "Obj must not be null");
        
        XMLInputFactory factory = XMLInputFactory.newInstance();
        try {
            XMLStreamReader reader = factory.createXMLStreamReader(inputStream);

            Class<?> clazz = obj.getClass();
            Map<String, Method> setterMethodMap = CachePool.getSetterMethods(clazz);
            if (setterMethodMap == null) {
                CachePool.putSetterMethodsIntoCachePool(clazz, ReflectUtils.getSetterMethods(clazz));
                setterMethodMap = CachePool.getSetterMethods(clazz);
            }
            
            while (reader.hasNext()) {
                int event = reader.next();
                if (event == XMLStreamConstants.START_ELEMENT) {
                    String element = reader.getLocalName();
                    Method method = setterMethodMap.get(element.toLowerCase());
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
