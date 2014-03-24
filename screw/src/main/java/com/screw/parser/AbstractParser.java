package com.screw.parser;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.screw.common.utils.ReflectUtils;

public abstract class AbstractParser implements Parser {

    private static final Logger logger = LoggerFactory.getLogger(AbstractParser.class);
    /**
     * Method象缓存池
     */
    protected Map<Class<?>, Map<String, Method>> setterPool = new ConcurrentHashMap<Class<?>, Map<String, Method>>();

    /**
     * 将反射过后的Method对象缓存
     * 
     * @param clazz
     */
    protected void addSetterMethod(Class<?> clazz) {
        Map<String, Method> setterMethodMap = setterPool.get(clazz);
        if (setterMethodMap == null) {
            synchronized (setterPool) {
                if (setterMethodMap == null) {
                    logger.info("add the method of ["+clazz.getName()+"] into setter pool");
                    Map<String, Method> setterMethod = ReflectUtils.getSetterMethods(clazz);
                    if (setterMethod != null && setterMethod.size() > 0) {
                        setterPool.put(clazz, setterMethod);
                    }
                }
            }
        }
    }
}
