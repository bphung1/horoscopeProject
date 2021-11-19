package mthree.avatar.horoscope.dto;

import java.time.LocalDateTime;

public class Prediction {

    private int predictionId;
    private String username;
    private LocalDateTime timestamp;
    private String horoscope;
    private String fortuneCookie;
    private int luckyNumbers;
    private String luckySportsTeam;
    private String luckyUniversity;
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

}
