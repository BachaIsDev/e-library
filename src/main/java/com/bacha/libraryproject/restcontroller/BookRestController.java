package com.bacha.libraryproject.restcontroller;

import com.bacha.libraryproject.entity.Book;
import com.bacha.libraryproject.entity.User;
import com.bacha.libraryproject.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library/api/books")
public class BookRestController {
    private final BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable(name = "id") int id){
        return bookService.getBookById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBookById(@RequestBody @PathVariable(name = "id") int id){
        bookService.deleteBookById(id);
    }

    @PutMapping
    public Book updateBook(@RequestBody Book book){
        return bookService.saveBook(book);
    }

    @PostMapping
    public Book addNewBook(@RequestBody Book book){
        return bookService.saveBook(book);
    }
}
