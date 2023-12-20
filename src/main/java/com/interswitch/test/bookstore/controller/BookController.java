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
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

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

    @Operation(summary = "search for book(s) by title, genre, author, yearOfPublication")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "successful"),
            @ApiResponse(responseCode = "500", description = "internal error - critical!")})
    @GetMapping()
    public ResponseEntity<List<BookDTO>> searchBook(
            @RequestParam(required = true) @Valid Integer limit,
            @RequestParam(required = false) @Valid Integer offset,
            @RequestParam(required = false) @Valid String title,
            @RequestParam(required = false) @Valid String genre,
            @RequestParam(required = false) @Valid String author,
            @RequestParam(required = false) @Valid String yearOfPublication
    ) {
        return ResponseEntity.ok(bookService.searchBook(limit, offset, title, genre, author, yearOfPublication));
    }
}
