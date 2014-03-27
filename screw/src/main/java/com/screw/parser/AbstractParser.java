package com.screw.parser;

import java.lang.reflect.Method;
import java.util.Map;

import com.screw.common.CachePool;
import com.screw.common.utils.ConvertUtils;
import com.screw.common.utils.ReflectUtils;


public abstract class AbstractParser implements Parser {

    protected void init(Class<?> clazz){
        Map<String, Method> setterMethodMap = CachePool.getSetterMethods(clazz);
        if (setterMethodMap == null) {
            Map<String, Method> methods = ReflectUtils.getSetterMethods(clazz);
            for(Method method : methods.values()){
                Class<?> type = method.getParameterTypes()[0];
                if(ConvertUtils.isCustomObject(type)){
                    init(type);
                }
            }
            CachePool.putSetterMethodsIntoCachePool(clazz, methods);
        }
    }
}
