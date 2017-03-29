package com.genband.util.annotation;

public class GenericTestThing {

    @GenericAnnotation(expected = GenericTestThing.class)
    public void justCall(String mean) {
        System.out.println("What do you say? " + mean);
    }

}
