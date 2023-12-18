package com.interswitch.test.bookstore.domain;

import jakarta.persistence.*;


@Entity
public class ShoppingCart {

    @Id
    private Long id;

    @Column
    private String listOfBooks;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getListOfBooks() {
        return listOfBooks;
    }

    public void setListOfBooks(final String listOfBooks) {
        this.listOfBooks = listOfBooks;
    }

}
