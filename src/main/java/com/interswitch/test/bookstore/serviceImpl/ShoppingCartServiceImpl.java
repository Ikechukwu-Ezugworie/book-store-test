package com.interswitch.test.bookstore.serviceImpl;

import com.interswitch.test.bookstore.domain.Book;
import com.interswitch.test.bookstore.domain.ShoppingCart;
import com.interswitch.test.bookstore.pojo.ShoppingCartDTO;
import com.interswitch.test.bookstore.respository.BookRepository;
import com.interswitch.test.bookstore.respository.ShoppingCartRepository;
import com.interswitch.test.bookstore.service.ShoppingCartService;
import com.musala.drones.exception.NotFoundException;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private ModelMapper modelMapper = new ModelMapper();


    @Autowired
    ShoppingCartRepository shoppingCartRepository;

    @Autowired
    BookRepository bookRepository;

    @Override
    public ShoppingCartDTO createShoppingCart() {
        logger.info("Creating a new shopping cart");
        ShoppingCart cart = new ShoppingCart(UUID.randomUUID().toString());
        ShoppingCart createdCart = shoppingCartRepository.save(cart);
        return modelMapper.map(createdCart, ShoppingCartDTO.class);
    }


    @Override
    public ShoppingCartDTO getShoppingCartById(String id) {
        logger.info("Retrieving shopping cart by Id: {}", id);
        ShoppingCart cartOptional = shoppingCartRepository.findById(id).orElseThrow(() -> {
            logger.info("Shopping cart with id: {} does not exist", id);
            return new NotFoundException("Shopping cart with id: " + id + " does not exist");
        });
        return modelMapper.map(cartOptional, ShoppingCartDTO.class);
    }

    @Override
    public ShoppingCartDTO addBookToShoppingCart(String cartId, List<String> bookIds) {
        logger.info("Adding books to shopping cart");
        Optional<ShoppingCart> optionalCart = shoppingCartRepository.findById(cartId);
        if (optionalCart.isEmpty()) {
            logger.info("Shopping cart not found with id: {}", cartId);
            throw new NotFoundException("Shopping cart not found with id: " + cartId);
        }

        List<Book> bookList = bookRepository.findAllById(bookIds);
        if (bookList.isEmpty()) {
            throw new NotFoundException("No book found with the following ids: " + bookIds);
        }
        ShoppingCart cart = optionalCart.get();
        cart.getListOfBooks().addAll(bookList);
        ShoppingCart updatedCart = shoppingCartRepository.save(cart);
        return modelMapper.map(updatedCart, ShoppingCartDTO.class);

    }
}
