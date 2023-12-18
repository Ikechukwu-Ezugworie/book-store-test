package com.interswitch.test.bookstore.service;

import com.interswitch.test.bookstore.domain.Book;
import com.interswitch.test.bookstore.pojo.BookDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {

    public BookDTO createBook(BookDTO book);

    public List<Book> getBookByTitle(String title);

    public List<Book> getBookByAuthor(String author);

    public List<Book> getBookByYearOfPublication(String yearOfPublication);

    public List<Book> getBookByGenre(String genre);
}
