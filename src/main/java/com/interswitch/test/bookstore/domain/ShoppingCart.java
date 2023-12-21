package com.interswitch.test.bookstore.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
public class ShoppingCart {

    @Id
    private String id;

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

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public List<Book> getListOfBooks() {
        return listOfBooks;
    }

    public void setListOfBooks(final List<Book> listOfBooks) {
        this.listOfBooks = listOfBooks;
    }

}
