package com.interswitch.test.bookstore.enums;

public enum Genre {
    FRICTION("FRICTION"), THRILLER("THRILLER"), MYSTERY("MYSTERY"), POETRY("POETRY"), HORROR("HORROR");

    private String genre;

    Genre(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
