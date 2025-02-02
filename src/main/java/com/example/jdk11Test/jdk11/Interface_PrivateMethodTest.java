package com.example.jdk11Test.jdk11;


import java.util.Date;

public class Interface_PrivateMethodTest {
    public static void main(String[] args) {
        Book book = new ItBook();
        System.out.println(book.getAuthor());
        System.out.println(Book.getWrittenDate());
    }
}

interface Book {
    public static final Date writtenDate = new Date();
    public static final String author = "depth";

    default String getAuthor() {
        return getDefaultAuthor();  // private 메서드 호출
    }

    static String getWrittenDate() {
        return String.valueOf(getDefaultWrittenDate()); // private static 메서드 호출
    }

    // private 메서드 - 인터페이스 내부에서만 호출 가능
    private String getDefaultAuthor() {
        return author;  // 기본 author 값을 반환
    }

    // private 메서드 - 인터페이스 내부에서만 호출 가능
    private static Date getDefaultWrittenDate() {
        return writtenDate;  // 기본 writtenDate 값을 반환
    }

}

class ItBook implements Book {
    //public String getAuthor() {
    //    return "steve";
    //}
}