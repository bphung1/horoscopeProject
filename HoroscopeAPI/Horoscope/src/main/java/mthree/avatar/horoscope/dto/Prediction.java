package mthree.avatar.horoscope.dto;

import java.time.LocalDateTime;
import java.util.Objects;

public class Prediction {

    private int predictionId;
    private String username;
    private LocalDateTime timestamp;
    private String horoscope;
    private String fortuneCookie;
    private int luckyNumbers;
    private String luckySportsTeam;
    private String luckyMovie;
    private String jokeOfTheDay;


    public int getPredictionId() {
        return predictionId;
    }

    public void setPredictionId(int predictionId) {
        this.predictionId = predictionId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getHoroscope() {
        return horoscope;
    }

    public void setHoroscope(String horoscope) {
        this.horoscope = horoscope;
    }

    public String getFortuneCookie() {
        return fortuneCookie;
    }

    public void setFortuneCookie(String fortuneCookie) {
        this.fortuneCookie = fortuneCookie;
    }

    public int getLuckyNumbers() {
        return luckyNumbers;
    }

    public void setLuckyNumbers(int luckyNumbers) {
        this.luckyNumbers = luckyNumbers;
    }

    public String getLuckySportsTeam() {
        return luckySportsTeam;
    }

    public void setLuckySportsTeam(String luckySportsTeam) {
        this.luckySportsTeam = luckySportsTeam;
    }

    public String getLuckyMovie() {
        return luckyMovie;
    }

    public void setLuckyMovie(String luckyMovie) {
        this.luckyMovie = luckyMovie;
    }

    public String getJokeOfTheDay() {
        return jokeOfTheDay;
    }

    public void setJokeOfTheDay(String jokeOfTheDay) {
        this.jokeOfTheDay = jokeOfTheDay;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prediction that = (Prediction) o;
        return predictionId == that.predictionId && Objects.equals(username, that.username) && Objects.equals(timestamp, that.timestamp) && Objects.equals(horoscope, that.horoscope);
    }

    @Override
    public int hashCode() {
        return Objects.hash(predictionId, username, timestamp, horoscope);
    }
}
