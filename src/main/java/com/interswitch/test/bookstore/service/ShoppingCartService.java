package com.interswitch.test.bookstore.service;

import com.interswitch.test.bookstore.pojo.ShoppingCartDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ShoppingCartService {

    public ShoppingCartDTO createShoppingCart(String userId);

    public ShoppingCartDTO getShoppingCartById(String id);

    public ShoppingCartDTO addBookToShoppingCart(String cartId, List<String> bookIds);
}
