package com.interswitch.test.bookstore.controller;

import com.interswitch.test.bookstore.pojo.BookDTO;
import com.interswitch.test.bookstore.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/books"/*, produces = MediaType.APPLICATION_JSON_VALUE*/)
public class BookController {

    @Autowired
    private BookService bookService;

    @Operation(summary = "create a new book")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "successful"),
            @ApiResponse(responseCode = "500", description = "internal error - critical!")})
    @PostMapping
    public ResponseEntity<BookDTO> createBook(@RequestBody @Valid BookDTO bookDTO){
        BookDTO createdBook = bookService.createBook(bookDTO);
        return new ResponseEntity<>(createdBook, HttpStatus.CREATED);
    }
}
