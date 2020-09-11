package com.moskaoud.leaderboard;

public class Data {
    int hours;
    int score;
    String country;
    String name;
    String badgeUrl;

    public Data(int hours, int score, String country, String name, String badgeUrl) {
        this.hours = hours;
        this.score = score;
        this.country = country;
        this.name = name;
        this.badgeUrl = badgeUrl;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBadgeUrl() {
        return badgeUrl;
    }

    public void setBadgeUrl(String badgeUrl) {
        this.badgeUrl = badgeUrl;
    }
}
