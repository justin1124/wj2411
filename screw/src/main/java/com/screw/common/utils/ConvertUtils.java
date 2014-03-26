package com.screw.common.utils;

import java.lang.reflect.Type;
import java.math.BigDecimal;

public class ConvertUtils {

    @SuppressWarnings("unchecked")
    public static <T> T convert(String value) {
        Object ret = null;
        if (VerifyUtils.isInteger(value)) {
            ret = Integer.parseInt(value);
        } else if (VerifyUtils.isLong(value)) {
            ret = Long.parseLong(value);
        } else if (VerifyUtils.isDouble(value)) {
            ret = Double.parseDouble(value);
        } else if (VerifyUtils.isFloat(value)) {
            ret = Float.parseFloat(value);
        } else
            ret = value;
        return (T) ret;
    }
    
    @SuppressWarnings("unchecked")
    public static <T> T convert(String value, Type type) {
        Object ret = null;
        if (type == int.class || type == Integer.class) {
            ret = Integer.parseInt(value);
        } else if (type == long.class || type == Long.class) {
            ret = Long.parseLong(value);
        } else if (type == double.class || type == Double.class) {
            ret = Double.parseDouble(value);
        } else if (type == float.class || type == Float.class) {
            ret = Float.parseFloat(value);
        } else if (type == boolean.class || type == Boolean.class) {
            ret = Boolean.parseBoolean(value);
        } else if (type == short.class || type == Short.class) {
            ret = Short.parseShort(value);
        } else if (type == byte.class || type == Byte.class) {
            ret = Byte.parseByte(value);
        } else if (type == BigDecimal.class) {
            ret = new BigDecimal(value);
        } else if (type == String.class) {
            ret = value;
        }

        return (T) ret;
    }
}
