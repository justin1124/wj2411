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
        if(type == Integer.TYPE){
            ret = Integer.parseInt(value);
        } else if(type == BigDecimal.class){
            ret = new BigDecimal(value);
        } else {
            ret = value;
        }
        
//        if (VerifyUtils.isInteger(value)) {
//            ret = Integer.parseInt(value);
//        } else if (VerifyUtils.isLong(value)) {
//            ret = Long.parseLong(value);
//        } else if (VerifyUtils.isDouble(value)) {
//            ret = Double.parseDouble(value);
//        } else if (VerifyUtils.isFloat(value)) {
//            ret = Float.parseFloat(value);
//        } else
//            ret = value;
        return (T) ret;
    }
}
