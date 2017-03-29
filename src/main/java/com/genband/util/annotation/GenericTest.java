package com.genband.util.annotation;

public class GenericTest {

    public static void main(String[] args) {
        GenericAnnotationParser parser = new GenericAnnotationParser();
        try {
            parser.parse(GenericTestThing.class);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        GenericTestThing gtt = new GenericTestThing();
        gtt.justCall("wha?");
        // you can use also Class.forName
        // to load from file system directly!
    }

}
