package com.screw;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.screw.common.utils.StringUtils;
import com.screw.exception.ScrewException;
import com.screw.parser.Parser;
import com.screw.parser.ParserConstants;
import com.screw.parser.ParserFactory;

/**
 * parse xml by StAX
 * 
 * @author 须俊杰
 * @2014-3-24
 */
public class StAXScrew implements Screw{

    private static final Logger logger = LoggerFactory.getLogger(StAXScrew.class);

    @Override
    public <T> T fromXML(String xml, Class<T> clazz) {
        if (StringUtils.isBlank(xml)) {
            throw new ScrewException("xml param can not be null");
        }
        if (clazz == null) {
            throw new ScrewException("clazz param can not be null");
        }

        InputStream inputStream = new ByteArrayInputStream(xml.getBytes());
        try {
            T obj = clazz.newInstance();
            Parser staxParser = ParserFactory.getParser(ParserConstants.STAX);
            staxParser.parse(inputStream, obj);

            return obj;
        } catch (Exception e) {
            logger.error("Convert error : Class = " + clazz.getName(), e);
            throw new ScrewException();
        }
    }
}
