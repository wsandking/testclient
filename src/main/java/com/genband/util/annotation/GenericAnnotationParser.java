package com.genband.util.annotation;

import java.lang.reflect.Method;

public class GenericAnnotationParser {
    public void parse(Class<?> clazz) throws Exception {
        Method[] methods = clazz.getMethods();
        int pass = 0;
        int fail = 0;
        for (Method method : methods) {
            if (method.isAnnotationPresent(GenericAnnotation.class)) {
                try {
                    method.invoke("What do you mean?" + pass);
                    pass++;
                } catch (Exception e) {
                    fail++;
                    System.err.println(fail);
                    e.printStackTrace();
                }
            }
        }
    }
}
