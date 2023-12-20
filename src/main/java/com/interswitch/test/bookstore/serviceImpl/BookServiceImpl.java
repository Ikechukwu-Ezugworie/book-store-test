package com.interswitch.test.bookstore.serviceImpl;

import com.interswitch.test.bookstore.domain.Book;
import com.interswitch.test.bookstore.pojo.BookDTO;
import com.interswitch.test.bookstore.respository.BookRepository;
import com.interswitch.test.bookstore.search.BookSpecifications;
import com.interswitch.test.bookstore.service.BookService;
import com.musala.drones.exception.NotFoundException;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    public List<BookDTO> searchBook(Integer limit, Integer offset, String title, String genre, String author, String yearOfPublication) {
        Map<String, String> queryParams = new HashMap<>();
        if (title != null){
            queryParams.put("title", title);
        }
        if (genre != null){
            queryParams.put("genre", genre);
        }
        if (author != null){
            queryParams.put("author", author);
        }
        if (yearOfPublication != null){
            queryParams.put("yearOfPublication", yearOfPublication);
        }
        logger.info("Retrieving book by these parameters: {}", queryParams);
        Specification<Book> spec = BookSpecifications.createSpecification(queryParams);
        List<Book> books = bookRepository.findAll(spec);
        if (books.isEmpty()) {
            logger.info("No book found with the  query parameters: {}", queryParams);
            throw new NotFoundException("No book found with these query parameters: " + queryParams);
        }
        return modelMapper.map(books, new TypeToken<List<BookDTO>>() {}.getType());
    }
}
