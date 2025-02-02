package com.example.jdk11Test.jdk11;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Try_With_Resources_Test {

    public static void main(String[] args) throws IOException {

//        Socket socket = null;
//        PrintWriter out = null;
//        BufferedReader in = null;

        Socket socket = new Socket("localhost", 8081);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);  // socket.getOutputStream()을 통해 서버로 데이터를 전송하는 출력 스트림을 설정
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));// socket.getInputStream()을 통해 서버로부터 데이터를 읽어들이는 입력 스트림을 설정

        try (socket; out; in;) { // socket.getInputStream()을 통해 서버로부터 데이터를 읽어들이는 입력 스트림을 설정

            out.println("GET / HTTP/1.1");       // 기본 페이지(/)로 요청 전달
            out.println("Host: localhost:8080");      // 요청하는 서버의 도메인(or IP) 지정
            out.println("Connection: Close");    // 요청을 처리 후 닫겠다는 의미
            out.println();

            String responseLine;
            while ((responseLine = in.readLine()) != null) {
                System.out.println(responseLine);
            }
        } catch (IOException e) {
            System.out.println("네트워크 연결 중 오류 발생: " + e.getMessage());
        }

        System.out.println("소켓 닫힘 상태: " + socket.isClosed());  // true

    }

}
