package com.screw;

/**
 * Xml解析
 * @author 须俊杰
 * @2014-3-21
 */
public interface Screw {

	<T> T fromXML(String xml, Class<T> clazz);
}
