package com.bacha.libraryproject.service;

import com.bacha.libraryproject.entity.Book;
import com.bacha.libraryproject.entity.User;
import com.bacha.libraryproject.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(int id){
        Optional<Book> book = bookRepository.findById(id);
        return book.orElse(null);
    }

    @Override
    public Book saveBook(Book book){
        return bookRepository.save(book);
    }

    @Override
    public void deleteBookById(int id){
        bookRepository.deleteById(id);
    }

}
