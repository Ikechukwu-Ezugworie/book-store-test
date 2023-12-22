package com.interswitch.test.bookstore.domain;

import com.interswitch.test.bookstore.enums.Genre;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;


@Entity
public class Book {

    @Id
    private String id;

    @Column
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$")
    private String title;

    @Column
    private Genre genre;

    @Column
    @Pattern(regexp = "^[0-9\\-]+$")
    private String isbn;

    @Column
    private String author;

    @Column
    private String yearOfPublication;

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(final Genre genre) {
        this.genre = genre;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(final String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(final String author) {
        this.author = author;
    }

    public String getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(final String yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

}
