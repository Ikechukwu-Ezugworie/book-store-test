package com.interswitch.test.bookstore.service;


import com.interswitch.test.bookstore.pojo.JWTAuthResponse;
import com.interswitch.test.bookstore.pojo.LoginDto;
import com.interswitch.test.bookstore.pojo.RegisterDto;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {
    JWTAuthResponse login(LoginDto loginDto);

    String register(RegisterDto registerDto);
}
