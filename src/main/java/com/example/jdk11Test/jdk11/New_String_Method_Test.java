package com.example.jdk11Test.jdk11;



public class New_String_Method_Test {
    public static void main(String[] args) {

        // 1. isBlank() - 문자열이 비어있거나 공백만 포함하는지 확인
        String str1 = "   ";
        String str2 = "Hello, World!";

        System.out.println(str1.isBlank()); // true
        System.out.println(str2.isBlank()); // false

        // 2. lines() - 문자열을 여러 줄로 분리
        String multilineStr = "Line 1\nLine 2\nLine 3";
        multilineStr.lines().forEach(System.out::println);

        // 3. strip() - 앞뒤 공백 제거 (Unicode 공백도 제거)
        String str3 = "  Hello World!  ";
        System.out.println(str3.strip()); // "Hello World!"

        // 4. stripLeading() - 앞 공백 제거
        String str4 = "  Hello World!  ";
        System.out.println(str4.stripLeading()); // "Hello World!  "

        // 5. stripTrailing() - 뒤 공백 제거
        System.out.println(str4.stripTrailing()); // "  Hello World!"

        // 6. repeat() - 문자열을 지정한 횟수만큼 반복
        String str5 = "Hi!";
        System.out.println(str5.repeat(3)); // "Hi!Hi!Hi!"
    }

}
