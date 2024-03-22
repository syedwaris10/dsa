package com.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Test1 implements TestJava8 {
    @Override
    public String getName() {
        return null;
    }


    public static void duplicate() {
        int[] arr = {1, 1, 2 , 3};
        Set<Integer> set = new HashSet<>();
        int[] l = Arrays.stream(arr).filter(a -> !set.add(a)).toArray();
        for (int a:l) {
            System.out.println(a);
        }
    }
    public static void main(String[] args) {
        duplicate();
    }


}
