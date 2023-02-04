package com.bacha.libraryproject.repository;

import com.bacha.libraryproject.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Book, Integer> {
}
