package mthree.avatar.horoscope.dao;

import org.springframework.web.reactive.function.client.WebClient;

public class ApiCallTest {

    public static void main(String[] args) {
        WebClient client = WebClient.create();

        WebClient.ResponseSpec responseSpec = client.get()
                .uri("https://ohmanda.com/api/horoscope/leo/")
                .retrieve();

        String responseBody = responseSpec.bodyToMono(String.class).block();

        System.out.println(responseBody);
    }
}
