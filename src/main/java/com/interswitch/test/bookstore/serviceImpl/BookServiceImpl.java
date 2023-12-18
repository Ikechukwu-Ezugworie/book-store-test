package com.interswitch.test.bookstore.serviceImpl;

import com.interswitch.test.bookstore.domain.Book;
import com.interswitch.test.bookstore.pojo.BookDTO;
import com.interswitch.test.bookstore.respository.BookRepository;
import com.interswitch.test.bookstore.service.BookService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class BookServiceImpl implements BookService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BookRepository bookRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public BookDTO createBook(BookDTO book) {
        logger.info("Creating a new book: {}", book);
        Book newBook = modelMapper.map(book, Book.class);
        newBook.setId(UUID.randomUUID().toString());
        newBook.setIsbn(UUID.randomUUID().toString());
        Book createdBook = bookRepository.save(newBook);
        return modelMapper.map(createdBook, BookDTO.class);
    }

    @Override
    public List<Book> getBookByTitle(String title) {
        return null;
    }

    @Override
    public List<Book> getBookByAuthor(String author) {
        return null;
    }

    @Override
    public List<Book> getBookByYearOfPublication(String yearOfPublication) {
        return null;
    }

    @Override
    public List<Book> getBookByGenre(String genre) {
        return null;
    }
}
