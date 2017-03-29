package com.genband.util.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.Set;

import org.reflections.Reflections;

import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface Test {
    String info() default "";
}

class Annotated {
    @Test(info = "AWESOME")
    public void foo(String myParam, String jimmyTheK) {
        System.out.println("I am the origin: " + myParam);
        System.out.println("I am the Jimmy: " + jimmyTheK);
    }
}

class SubAnnotated extends Annotated {
    @Test(info = "AWESOME")
    public void foo(String myParam, String jimmyTheK) {
        System.out.println("SubAnnotated: " + myParam);
        System.out.println("SubAnnotated:  " + jimmyTheK);
    }
}

class TestAnnotationParser {

    public static Method[] amethods = new Method[10];;
    public static Annotated annotationClass = new Annotated();
    public static SubAnnotated subannotation = new SubAnnotated();
    private int count = 0;

    public void parse(Class<?> clazz, String thePlan) throws Exception {
        Method[] methods = clazz.getMethods();
        
        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class)) {
                Test test = method.getAnnotation(Test.class);

                String info = test.info();

                if ("AWESOME".equals(info)) {
                    System.out.println("info is awesome!");
                    // try to invoke the method with param
                    System.out.println("Register count " + count + " : " + clazz.getTypeName());
                    amethods[count++] = method;

                    method.invoke(clazz.newInstance(), info, thePlan);
                }
            }
        }
    }
}

public class TotalTest {
    public static void main(String[] args) throws Exception {
        TestAnnotationParser parser = new TestAnnotationParser();
        
        parser.parse(Annotated.class, "What is the plan? ");
        parser.parse(SubAnnotated.class, "What is the plan? ");
        
        TestAnnotationParser.amethods[0].invoke(TestAnnotationParser.annotationClass, "The newthing", "the Class");
        TestAnnotationParser.amethods[1].invoke(TestAnnotationParser.annotationClass, "The newthing", "the Class");
        
        Reflections reflections = new Reflections("com.genband.util.test.client");

        Set<Class<? extends Object>> allClasses = reflections.getSubTypesOf(Object.class);
        for (Class<?> haha : allClasses) {
            System.out.println(haha.getTypeName());
        }

    }
}
