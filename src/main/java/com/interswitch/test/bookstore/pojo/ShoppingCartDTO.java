package com.interswitch.test.bookstore.pojo;

import com.interswitch.test.bookstore.domain.Book;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartDTO {
    private String id;
    private List<Book> listOfBooks = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Book> getListOfBooks() {
        return listOfBooks;
    }

    public void setListOfBooks(List<Book> listOfBooks) {
        this.listOfBooks = listOfBooks;
    }
}
