package com.test;

@FunctionalInterface
public interface TestJava8 extends Test1Java8{

    public String getName();
    public default String test() {
        return "hi";
    }

    public default String test2() {
        return "hi";
    }
}
