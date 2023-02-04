package com.bacha.libraryproject.service;

import com.bacha.libraryproject.entity.Book;

import java.util.List;


public interface BookService {
    List<Book> getAllBooks();

    Book getBookById(int id);

    Book saveBook(Book user);

    void deleteBookById(int id);
}
