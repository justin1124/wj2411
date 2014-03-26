package com.screw;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.screw.common.utils.Assert;
import com.screw.exception.ScrewException;
import com.screw.parser.Parser;
import com.screw.parser.ParserConstants;
import com.screw.parser.ParserFactory;

/**
 * 使用StAX解析XML
 * 
 * @author 须俊杰
 * @2014-3-24
 */
public class StAXScrew implements Screw {

    private static final Logger logger = LoggerFactory.getLogger(StAXScrew.class);

    @Override
    public <T> T fromXML(String xml, Class<T> clazz) {
        Assert.notNull(xml, "XML must not be null");
        Assert.notNull(clazz, "Clazz must not be null");
        long start = System.currentTimeMillis();

        InputStream inputStream = new ByteArrayInputStream(xml.getBytes());
        try {
            T obj = clazz.newInstance();
            Parser staxParser = ParserFactory.getParser(ParserConstants.STAX);
            staxParser.parse(inputStream, obj);

            logger.info("XML解析完毕,耗时:" + (System.currentTimeMillis() - start));
            return obj;
        } catch (Exception e) {
            logger.error("XML解析异常 : Class = " + clazz.getName(), e);
            throw new ScrewException();
        }
    }
}
