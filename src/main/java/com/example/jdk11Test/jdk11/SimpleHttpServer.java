package com.example.jdk11Test.jdk11;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class SimpleHttpServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8081)) {  // 8080 포트에서 서버 소켓 생성
            System.out.println("서버가 시작되었습니다. 포트: 8081");

            while (true) {
                try (Socket clientSocket = serverSocket.accept();  // 클라이언트 연결을 대기
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                    String inputLine;
                    // 클라이언트로부터 HTTP 요청을 한 줄씩 읽음
                    while ((inputLine = in.readLine()) != null) {
                        System.out.println("요청 받음: " + inputLine);

                        // 클라이언트가 요청을 끝내면 (빈 줄로 끝남)
                        if (inputLine.isEmpty()) {
                            break;
                        }
                    }

                    // HTTP 응답을 전송
                    out.println("HTTP/1.1 200 OK");
                    out.println("Content-Type: text/plain");
                    out.println("Connection: close");
                    out.println();  // 빈 줄을 보내서 헤더 종료

                    out.println("[서버로부터의 응답] 요청이 성공적으로 처리되었습니다.");
                } catch (IOException e) {
                    System.out.println("클라이언트 처리 중 오류 발생: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("서버 오류 발생: " + e.getMessage());
        }
    }
}