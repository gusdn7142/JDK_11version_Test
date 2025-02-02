package com.example.jdk11Test.jdk11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class CollectionFactoryMethodTest {
    public static void main(String[] args) {

        //1) 일반 List를 불변 List로 변환
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Cherry");
        list.add("Banana");
        list = Collections.unmodifiableList(list); // 불변 컬렉션으로 변환
        System.out.println(list);

        //2) 불변 List 생성
        List<String> immutablelist = List.of("Apple", "Cherry", "Banana"); // 바로 (@Stable) 불변 리스트 생성
        System.out.println(immutablelist);
    }
}
