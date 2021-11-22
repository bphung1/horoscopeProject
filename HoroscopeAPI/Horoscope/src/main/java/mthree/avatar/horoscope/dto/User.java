package mthree.avatar.horoscope.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class User {

    private String username;
    private String password;
    private String name;
    private LocalDate birthday;
    private List<Prediction> predictions;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public List<Prediction> getPredictions() {
        return predictions;
    }

    public void setPredictions(List<Prediction> predictions) {
        this.predictions = predictions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(name, user.name) && Objects.equals(birthday, user.birthday) && Objects.equals(predictions, user.predictions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, name, birthday, predictions);
    }
}
