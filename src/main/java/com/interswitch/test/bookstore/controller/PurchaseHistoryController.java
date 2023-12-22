package com.interswitch.test.bookstore.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/history")
public class PurchaseHistoryController {

    @GetMapping("/{userId}")
    public String getPurchaseHistory(@PathVariable String userId) {
        // Retrieve and return the purchase history for the user
        // You might want to store purchase history in a database
        return "Purchase history for user " + userId;
    }
}
