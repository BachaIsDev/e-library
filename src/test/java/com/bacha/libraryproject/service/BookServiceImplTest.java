package com.bacha.libraryproject.service;

import com.bacha.libraryproject.entity.Book;
import com.bacha.libraryproject.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BookServiceImplTest {
    private static final int ID = 1;

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookServiceImpl bookService;

    @Test
    void getAllBooks_shouldReturnUsers_whenExist() {
        List<Book> books = List.of(mock(Book.class), mock(Book.class));
        when(bookRepository.findAll()).thenReturn(books);

        List<Book> actualBooks = bookService.getAllBooks();

        assertNotNull(actualBooks);
        assertEquals(books, actualBooks);
        verify(bookRepository).findAll();

    }

    @Test
    void getBookById_shouldCallRepo() {
        Book book = mock(Book.class);
        when(bookRepository.findById(ID)).thenReturn(Optional.of(book));

        Book actualBook = bookService.getBookById(ID);

        assertNotNull(actualBook);
        assertEquals(book, actualBook);
        verify(bookRepository).findById(ID);
    }

    @Test
    void saveBook_shouldCallRepo() {
        Book book = mock(Book.class);

        bookService.saveBook(book);

        verify(bookRepository).save(book);
    }

    @Test
    void deleteBookById_shouldCallRepo() {
        Book book = mock(Book.class);

        bookService.saveBook(book);
        bookService.deleteBookById(ID);

        verify(bookRepository).deleteById(ID);
    }
}