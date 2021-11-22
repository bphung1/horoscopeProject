package mthree.avatar.horoscope.service;

import mthree.avatar.horoscope.dao.PredictionDao;
import mthree.avatar.horoscope.dao.UserDao;
import mthree.avatar.horoscope.dto.Prediction;
import mthree.avatar.horoscope.dto.User;
import mthree.avatar.horoscope.models.Fortune;
import mthree.avatar.horoscope.models.Horoscope;
import mthree.avatar.horoscope.models.Joke;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
public class HoroscopeService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private PredictionDao predictionDao;

    public User createAccount(User user) {
        if (userDao.getUserByUsername(user.getUsername()) == null) {
            return null;
        }
        else {
            return userDao.addUser(user);
        }
    }

    public User login(User user) {
        User fetchedUserInfo = userDao.getUserByUsername(user.getUsername());
        if (fetchedUserInfo == null || !matchPassword(user.getPassword(), fetchedUserInfo.getPassword())) {
            return null;
        }
        else {
            return fetchedUserInfo;
        }
    }

    public Prediction generateHoroscope(User user) throws IOException {
        Prediction prediction = new Prediction();
        prediction.setUsername(user.getUsername());
        prediction.setTimestamp(LocalDateTime.now());
        prediction.setHoroscope(getHoroscope(user.getBirthday()));
        prediction.setFortuneCookie(getFortune());
        prediction.setLuckyNumbers(getLuckyNumber());
        prediction.setLuckySportsTeam(getSportsTeam());
        prediction.setLuckyMovie(getMovie());

        return predictionDao.addPrediction(prediction);
    }

    public List<Prediction> getAllHoroscopes(String username) {
        return predictionDao.getPredictionsForUser(username);
    }

    public User updateUserInfo(User user) {
        return userDao.editUser(user);
    }

    public boolean deleteHoroscope(Prediction prediction) {
        return predictionDao.deletePrediction(prediction);
    }


    private boolean matchPassword(String submittedPass, String fetchedPass) {
        return submittedPass.equals(fetchedPass);
    }

    private String getHoroscope(LocalDate birthday) {
        String url = "https://ohmanda.com/api/horoscope/" + getSign(birthday) + "/";

        WebClient client = WebClient.create();
        Horoscope horoscope = client.get()
                .uri(url)
                .retrieve()
                .bodyToMono(Horoscope.class)
                .block();

        if (horoscope.getHoroscope() == null) {
            return "Unable to generate horoscope. Try again tomorrow!";
        }
        else {
            return horoscope.getHoroscope();
        }
    }

    private String getFortune() {
        WebClient client = WebClient.create();
        Fortune fortune = client.get()
                .uri("http://yerkee.com/api/fortune/")
                .retrieve()
                .bodyToMono(Fortune.class)
                .block();

        if (fortune.getFortune() == null) {
            return "Unable to generate fortune. Try again tomorrow!";
        }
        else {
            return fortune.getFortune();
        }
    }

    private String getJoke() {
        WebClient client = WebClient.create();
        Joke joke = client.get()
                .uri("https://v2.jokeapi.dev/joke/Any?blacklistFlags=nsfw,religious,political,racist,sexist,explicit&type=twopart")
                .retrieve()
                .bodyToMono(Joke.class)
                .block();

        if (joke.getSetup() == null || joke.getDelivery() == null) {
            return "Unable to generate joke. Try again tomorrow!";
        }
        else {
            return joke.getJoke();
        }
    }

    private int getLuckyNumber() {
        Random random = new Random();
        return random.nextInt(100) + 1;
    }

    private String getSportsTeam() throws IOException {
        Random random = new Random();
        int randNum = random.nextInt(160);
        return Files.readAllLines(Paths.get("sportsteams.txt")).get(randNum);
    }

    private String getMovie() throws IOException {
        Random random = new Random();
        int randNum = random.nextInt(250);
        return Files.readAllLines(Paths.get("movies.txt")).get(randNum);
    }

    private String getSign(LocalDate birthday) {
        switch(birthday.getMonthValue()){
            case 1:
                return birthday.getDayOfMonth() >= 20 ? "aquarius" : "capricorn";
            case 2:
                return birthday.getDayOfMonth() >= 19 ? "pisces" : "aquarius";
            case 3:
                return birthday.getDayOfMonth() >= 21 ? "aries" : "pisces";
            case 4:
                return birthday.getDayOfMonth() >= 20 ? "taurus" : "aries";
            case 5:
                return birthday.getDayOfMonth() >= 21 ? "gemini" : "taurus";
            case 6:
                return birthday.getDayOfMonth() >= 21 ? "cancer" : "gemini";
            case 7:
                return birthday.getDayOfMonth() >= 23 ? "leo" : "cancer";
            case 8:
                return birthday.getDayOfMonth() >= 23 ? "virgo" : "leo";
            case 9:
                return birthday.getDayOfMonth() >= 23 ? "libra" : "virgo";
            case 10:
                return birthday.getDayOfMonth() >= 23 ? "scorpio" : "libra";
            case 11:
                return birthday.getDayOfMonth() >= 22 ? "sagittarius" : "scorpio";
            case 12:
                return birthday.getDayOfMonth() >= 22 ? "capricorn" : "sagittarius";
            default:
                return "getSign() default case";
        }
    }
}
