package com.screw;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.screw.common.utils.ReflectUtils;

public abstract class AbstractScrew implements Screw {

    protected Map<Class<?>, Map<String, Method>> setterCache = new ConcurrentHashMap<Class<?>, Map<String, Method>>();

    protected void addSetterMethod(Class<?> clazz) {
        Map<String, Method> setterMethodMap = setterCache.get(clazz);
        if (setterMethodMap == null) {
            synchronized (setterCache) {
                if (setterMethodMap == null) {
                    Map<String, Method> setterMethod = ReflectUtils.getSetterMethods(clazz);
                    if (setterMethod != null && setterMethod.size() > 0) {
                        setterCache.put(clazz, setterMethod);
                    }
                }
            }
        }
    }
}
