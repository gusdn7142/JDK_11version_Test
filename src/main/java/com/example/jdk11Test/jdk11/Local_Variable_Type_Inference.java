package com.example.jdk11Test.jdk11;

import java.util.ArrayList;


public class Local_Variable_Type_Inference {
    public static void main(String[] args) {
        //1) var 사용 - 일반 타입
        var strValue = "Hello, World!";   // 컴파일러가 String 타입을 추론
        var intVlaue = 42;                 // 컴파일러가 int 타입을 추론
        var diubleValue = 3.14;             // 컴파일러가 double 타입을 추론

        // 출력
        System.out.println("strValue: " + strValue);
        System.out.println("intVlaue: " + intVlaue);
        System.out.println("diubleValue: " + diubleValue);

        //2) var 사용 - Collection
        var list = new ArrayList<String>();  // 컴파일러가 ArrayList<String> 타입을 추론
        list.add("Java");
        list.add("Python");

        // 출력
        for (var value : list) {
            System.out.println(value);
        }
    }
}
