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
import com.screw.exception.ScrewException;

public class StAXParser extends AbstractParser {

    private static final Logger logger = LoggerFactory.getLogger(StAXParser.class);
    
    @SuppressWarnings("unchecked")
    @Override
    public <T> T parse(InputStream inputStream, Class<?> clazz){
        Assert.notNull(inputStream, "InputStream不能为空");
        Assert.notNull(clazz, "Clazz不能为空");
        
        try {
            init(clazz);
            Object obj = clazz.newInstance();

            
            Map<String, Method> setterMethodMap = CachePool.getSetterMethods(clazz);
            
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLStreamReader reader = factory.createXMLStreamReader(inputStream);
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
            return (T) obj;
        } catch (Exception e) {
            logger.error("解析错误 : Class = " + clazz.getName(), e);
            throw new ScrewException();
        }
    }
}
