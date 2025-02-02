package com.example.jdk11Test.jdk11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;


public class HttpClientTest {
    public static void main(String[] args) throws IOException, InterruptedException {

        String uri = "http://localhost:8081";

        try {
            System.out.println("=== HttpURLConnection 방식 ===");
            String responseFromHttpURLConnection = sendRequestWithHttpURLConnection(uri);
            printResponse(responseFromHttpURLConnection);

            Thread.sleep(5000);

            System.out.println("\n=== HttpClient 방식 ===");
            String responseFromHttpClient = sendRequestWithHttpClient(uri);
            printResponse(responseFromHttpClient);

        } catch (Exception e) {
            System.out.println("HTTP 요청 중 오류 발생: " + e.getMessage());
        }
    }




    /**
     * HttpURLConnection을 사용하여 HTTP GET 요청
     *
     * @param uri 요청할 URL
     * @return 응답 본문
     * @throws Exception 예외 발생 시
     */
    public static String sendRequestWithHttpURLConnection(String uri) throws Exception {
        URL url = new URL(uri);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // 요청 설정
        connection.setRequestMethod("GET");
        connection.setRequestProperty("key1", "value1");
        connection.setRequestProperty("key2", "value2");

        // 응답 상태 확인
        int responseCode = connection.getResponseCode();
        if (responseCode != HttpURLConnection.HTTP_OK) {
            throw new RuntimeException("HTTP GET 요청 실패: 응답 코드 = " + responseCode);
        }

        // 응답 데이터 읽기
        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                response.append(line).append("\n");
            }
            return response.toString();
        } finally {
            connection.disconnect(); // 연결 해제
        }
    }




    /**
     * HttpClient를 사용하여 HTTP GET 요청
     *
     * @param uri 요청할 URL
     * @return 응답 본문
     * @throws Exception 예외 발생 시
     */
    public static String sendRequestWithHttpClient(String uri) throws Exception {
        HttpClient client = HttpClient.newHttpClient();

        // 요청 생성
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .version(HttpClient.Version.HTTP_2) // HTTP/2 사용
                .header("key1", "value1")
                .header("key2", "value2")
                .timeout(Duration.ofSeconds(10)) // 타임아웃 설정
                .GET()
                .build();

        // 요청 보내기 및 응답 처리
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // 응답 상태 코드 확인
        if (response.statusCode() != 200) {
            throw new RuntimeException("HTTP GET 요청 실패: 응답 코드 = " + response.statusCode());
        }

        return response.body();
    }


    /**
     * 응답 내용을 출력합니다.
     *
     * @param response 응답 본문
     */
    public static void printResponse(String response) {
        System.out.println("응답 본문:");
        System.out.println(response);
    }

}

