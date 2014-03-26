package com.screw.common;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.screw.common.utils.Assert;

/**
 * 缓存池
 * 
 * @author 须俊杰
 * @2014-3-26
 */
public abstract class CachePool {

    private static final Logger logger = LoggerFactory.getLogger(CachePool.class);
    private static final Map<Class<?>, Map<String, Method>> SETTERMETHODPOOL = new ConcurrentHashMap<Class<?>, Map<String, Method>>();

    /**
     * 根据指定的属性名和对象类型从缓存中去除属性对应的setter方法对象
     * 
     * @param propertyName 属性名
     * @param key 对象类型
     * @return 属性对应的setter方法
     */
    public static Method getSetterMethodByPropertyName(String propertyName,
            Class<?> key) {
        Assert.notNull(propertyName, "PropertyName must not be null");
        Assert.notNull(key, "Key must not be null");

        Map<String, Method> map = SETTERMETHODPOOL.get(key);
        if (map != null) {
            map.get(propertyName);
        }

        return null;
    }
    
    /**
     * 根据指定的属性名和对象类型从缓存中去除属性对应的setter方法对象
     * 
     * @param propertyName 属性名
     * @param key 对象类型
     * @return 属性对应的setter方法
     */
    public static Map<String, Method> getSetterMethods(Class<?> key) {
        Assert.notNull(key, "Key must not be null");

        return SETTERMETHODPOOL.get(key);
    }
    
    /**
     * 将setter方法加入缓存当中
     * 
     * @param key
     * @param setterMethodMap
     */
    public static void putSetterMethodsIntoCachePool(Class<?> key,
            Map<String, Method> setterMethodMap) {
        Assert.notNull(setterMethodMap, "SetterMethodMap must not be null");
        Assert.notNull(key, "Key must not be null");

        Map<String, Method> map = SETTERMETHODPOOL.get(key);
        if (map == null) {
            synchronized (SETTERMETHODPOOL) {
                if (map == null) {
                    logger.info("将对象[" + key.getName() + "]的所有setter方法加入缓存");
                    SETTERMETHODPOOL.put(key, setterMethodMap);
                }
            }
        }
    }
}
