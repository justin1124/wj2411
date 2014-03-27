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
 * 解析XML
 * 
 * @author 须俊杰
 * @2014-3-24
 */
public abstract class Screw{

    private static final Logger logger = LoggerFactory.getLogger(Screw.class);

    /**
     * 将XML字符串转换成指定类型的对象
     * @param xml XML字符串
     * @param clazz 对象类型
     * @param parser 解析器
     * @return 指定类型对象的实例
     */
    public static <T> T fromXML(String xml, Class<T> clazz, Parser parser) {
        Assert.notNull(xml, "XML不能为空");
        Assert.notNull(clazz, "Clazz不能为空");
        long start = System.currentTimeMillis();

        InputStream inputStream = new ByteArrayInputStream(xml.getBytes());
        try {
            T obj = clazz.newInstance();
            parser.parse(inputStream, obj);

            logger.info("XML解析完毕,耗时:" + (System.currentTimeMillis() - start));
            return obj;
        } catch (Exception e) {
            logger.error("XML解析异常 : Class = " + clazz.getName(), e);
            throw new ScrewException();
        }
    }
    
    /**
     * 将XML字符串转换成指定类型的对象,默认使用StAX
     * @param xml XML字符串
     * @param clazz 对象类型
     * @return 指定类型对象的实例
     */
    public static <T> T fromXML(String xml, Class<T> clazz) {
        Parser staxParser = ParserFactory.getParser(ParserConstants.STAX);
        return fromXML(xml, clazz, staxParser);
    }
}
