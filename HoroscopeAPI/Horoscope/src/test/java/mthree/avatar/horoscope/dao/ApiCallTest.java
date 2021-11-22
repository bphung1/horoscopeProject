package mthree.avatar.horoscope.dao;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

public class ApiCallTest {

    public static void main(String[] args) {
        WebClient client = WebClient.create();

        WebClient.ResponseSpec responseSpec = client.get()
                .uri("https://icanhazdadjoke.com/")
                .accept(MediaType.TEXT_PLAIN)
                .retrieve();

        String responseBody = responseSpec.bodyToMono(String.class).block();

        System.out.println(responseBody);
    }
}
