import mthree.avatar.horoscope.models.Fortune;
import mthree.avatar.horoscope.models.Horoscope;
import mthree.avatar.horoscope.models.Joke;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class Test {
    public static void main(String[] args) throws IOException {
        WebClient client = WebClient.create();

        Horoscope horoscope = client.get()
                .uri("https://ohmanda.com/api/horoscope/aquarius/")
                .retrieve()
                .bodyToMono(Horoscope.class)
                .block();

        Fortune fortune = client.get()
                .uri("http://yerkee.com/api/fortune/")
                .retrieve()
                .bodyToMono(Fortune.class)
                .block();

        Joke joke = client.get()
                .uri("https://v2.jokeapi.dev/joke/Any?blacklistFlags=nsfw,religious,political,racist,sexist,explicit&type=twopart")
                .retrieve()
                .bodyToMono(Joke.class)
                .block();

        Random random = new Random();
        int luckyNumber = random.nextInt(99) + 1;
        int sportsTeam = random.nextInt(160);
        int movie = random.nextInt(250);

        String randLine = Files.readAllLines(Paths.get("sportsteams.txt")).get(sportsTeam);
        String movieLine = Files.readAllLines(Paths.get("movies.txt")).get(movie);

        System.out.println(movieLine);


    }
}
