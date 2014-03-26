package com.screw.common.utils;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/**
 * 反射工具类
 * 
 * @author 须俊杰
 * @2014年3月23日
 */
public class ReflectUtils {

    /**
     * 获取对象的所有setter方法
     * @param clazz
     * @return
     */
	public static Map<String, Method> getSetterMethods(Class<?> clazz) {
		Map<String, Method> setterMethodMap = new HashMap<String, Method>();
		Method[] methods = clazz.getMethods();

		for (Method method : methods) {
			method.setAccessible(true);
			if (method.getName().length() < 4
				|| !Character.isUpperCase(method.getName().charAt(3))
				|| !method.getName().startsWith("set")
				|| Modifier.isStatic(method.getModifiers())
				|| !method.getReturnType().equals(Void.TYPE)
				|| method.getParameterTypes().length != 1){
			    continue;
			}
			
			String propertyName = getPropertyName(method);
			setterMethodMap.put(propertyName, method);
		}
		return setterMethodMap;
	}
	
	/**
	 * 获取setter方法对应属性名称
	 * @param method
	 * @return
	 */
	public static String getPropertyName(Method method) {
		String methodName = method.getName();
		int index = (methodName.charAt(0) == 'i' ? 2 : 3);	// 处理boolean类型属性
		String propertyName = Character.toLowerCase(methodName.charAt(index)) + methodName.substring(index + 1);
		return propertyName;
	}
}
