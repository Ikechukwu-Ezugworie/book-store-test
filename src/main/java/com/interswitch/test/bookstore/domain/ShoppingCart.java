package com.interswitch.test.bookstore.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
public class ShoppingCart {

    @Id
    private String id;

    private String userId;

    @ManyToMany
    @JoinTable(
            name = "shopping_cart_books",
            joinColumns = @JoinColumn(name = "shopping_cart_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private List<Book> listOfBooks = new ArrayList<>();

    public ShoppingCart() {
    }

    public ShoppingCart(String id) {
        this.id = id;
    }

    public ShoppingCart(String id, String userId) {
        this.id = id;
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Book> getListOfBooks() {
        return listOfBooks;
    }

    public void setListOfBooks(final List<Book> listOfBooks) {
        this.listOfBooks = listOfBooks;
    }

}
