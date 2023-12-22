package com.interswitch.test.bookstore.pojo;

import com.interswitch.test.bookstore.enums.Genre;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public class BookDTO {
    private String id;

    @Pattern(regexp = "^[a-zA-Z0-9 ]+$")
    private String title;
    private Genre genre;

    @Pattern(regexp = "^[0-9\\-]+$")
    private String isbn;
    private String author;
    private String yearOfPublication;

    public BookDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(String yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }
}
