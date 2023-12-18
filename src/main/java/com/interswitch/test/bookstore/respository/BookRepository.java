package com.interswitch.test.bookstore.respository;

import com.interswitch.test.bookstore.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
