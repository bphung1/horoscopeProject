package mthree.avatar.horoscope.models;

public class Joke {
    private String setup;
    private String delivery;

    public String getSetup() {
        return setup;
    }

    public void setSetup(String setup) {
        this.setup = setup;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public String getJoke() {
        return setup + " " + delivery;
    }
}
