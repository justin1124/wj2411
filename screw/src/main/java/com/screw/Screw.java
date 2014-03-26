package com.screw;

/**
 * 解析XML
 * @author 须俊杰
 * @2014-3-21
 */
public interface Screw {

    /**
     * 将XML字符串转换成指定类型的对象
     * @param xml XML字符串
     * @param clazz 对象类型
     * @return 指定类型对象的实例
     */
	<T> T fromXML(String xml, Class<T> clazz);
	
}
