package com.screw;

/**
 * parse xml
 * @author 须俊杰
 * @2014-3-21
 */
public interface Screw {

    /**
     * convert xml string to object of clazz
     * @param xml xml format string
     * @param clazz 
     * @return The instance of the clazz
     */
	<T> T fromXML(String xml, Class<T> clazz);
	
}
