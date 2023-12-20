package com.interswitch.test.bookstore.service;

import com.interswitch.test.bookstore.pojo.BookDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {

    public BookDTO createBook(BookDTO book);

    public List<BookDTO> searchBook(
            Integer limit, Integer offset,
            String title, String genre,
            String author, String yearOfPublication
    );
}
