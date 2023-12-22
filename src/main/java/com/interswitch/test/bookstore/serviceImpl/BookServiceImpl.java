package com.interswitch.test.bookstore.serviceImpl;

import com.interswitch.test.bookstore.domain.Book;
import com.interswitch.test.bookstore.exception.NotFoundException;
import com.interswitch.test.bookstore.pojo.BookDTO;
import com.interswitch.test.bookstore.respository.BookRepository;
import com.interswitch.test.bookstore.search.BookSpecifications;
import com.interswitch.test.bookstore.service.BookService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.*;

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
        newBook.setIsbn(generateIsbn());
        Book createdBook = bookRepository.save(newBook);
        return modelMapper.map(createdBook, BookDTO.class);
    }

    @Override
    public List<BookDTO> searchBook(String title, String genre, String author, String yearOfPublication) {
        Map<String, String> queryParams = new HashMap<>();
        List<Book> books;
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
        if (!queryParams.isEmpty()){
            logger.info("Retrieving book by these parameters: {}", queryParams);
            Specification<Book> spec = BookSpecifications.createSpecification(queryParams);
            books = bookRepository.findAll(spec);
        }else {
            books = bookRepository.findAll();
        }

        if (books.isEmpty()) {
            logger.info("No book found with the  query parameters: {}", queryParams);
            throw new NotFoundException("No book found with these query parameters: " + queryParams);
        }
        return modelMapper.map(books, new TypeToken<List<BookDTO>>() {}.getType());
    }

    private static String generateIsbn() {
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MMdd-HHmmss");
        String timestamp = dateFormat.format(currentDate);
        String uniqueIdentifier = String.valueOf((int) (Math.random() * 1000));
        String isbn = timestamp + "-" + uniqueIdentifier;
        return isbn;
    }
}
