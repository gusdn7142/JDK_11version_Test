package com.example.jdk11Test.jdk11;

import java.util.Arrays;
import java.util.List;

public class CollectionToArray_Test {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "banana", "orange");

        //1) Java 8: stream()을 사용하여 배열로 변환
        String[] arrayByJava8 = list.stream()    // List -> Stream -> 배열
                .toArray(String[]::new);         // 배열로 변환

        System.out.println(Arrays.toString(arrayByJava8));


        //2) Java 11: List에서 직접 toArray() 호출
        String[] arrayByJava11 = list.toArray(String[]::new); // List -> 배열
        System.out.println(Arrays.toString(arrayByJava11));
    }


}
