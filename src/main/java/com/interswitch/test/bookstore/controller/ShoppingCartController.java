package com.interswitch.test.bookstore.controller;

import com.interswitch.test.bookstore.pojo.BookDTO;
import com.interswitch.test.bookstore.pojo.ShoppingCartDTO;
import com.interswitch.test.bookstore.service.BookService;
import com.interswitch.test.bookstore.service.ShoppingCartService;
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

@RestController
@RequestMapping(value = "/api/shopping-cart", produces = MediaType.APPLICATION_JSON_VALUE)
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @Operation(summary = "create a new shopping cart")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "successful"),
            @ApiResponse(responseCode = "500", description = "internal error - critical!")})
    @PostMapping
    public ResponseEntity<ShoppingCartDTO> createShoppingCart(){
        ShoppingCartDTO createdCart = shoppingCartService.createShoppingCart();
        return new ResponseEntity<>(createdCart, HttpStatus.CREATED);
    }

    @Operation(summary = "add a book to a shopping cart")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "successful"),
            @ApiResponse(responseCode = "500", description = "internal error - critical!")})
    @PutMapping("{id}")
    public ResponseEntity<ShoppingCartDTO> addBookToShoppingCart(@PathVariable @Valid String id, @RequestBody List<String> bookIds){
        ShoppingCartDTO updatedCart = shoppingCartService.addBookToShoppingCart(id, bookIds);
        return new ResponseEntity<>(updatedCart, HttpStatus.OK);
    }

    @Operation(summary = "get a shopping cart by Id")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "successful"),
            @ApiResponse(responseCode = "500", description = "internal error - critical!")})
    @GetMapping("{id}")
    public ResponseEntity<ShoppingCartDTO> getShoppingCartById(@PathVariable @Valid String id){
        ShoppingCartDTO createdCart = shoppingCartService.getShoppingCartById(id);
        return new ResponseEntity<>(createdCart, HttpStatus.OK);
    }


}
