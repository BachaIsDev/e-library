package com.bacha.libraryproject.restcontroller;

import com.bacha.libraryproject.entity.Book;
import com.bacha.libraryproject.service.BookServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookRestControllerTest {
    private static final int ID = 1;

    @Mock
    private BookServiceImpl bookService;

    @InjectMocks
    private BookRestController bookRestController;

    @Test
    void getAllBooks_shouldReturnsAllBooks_whenExist(){
        List<Book> books = List.of(mock(Book.class), mock(Book.class));
        when(bookService.getAllBooks()).thenReturn(books);

        List<Book> actualBooks = bookRestController.getAllBooks();

        assertNotNull(actualBooks);
        assertEquals(actualBooks, books);
        verify(bookService).getAllBooks();
    }

    @Test
    void getBookById_shouldReturnsBook_whenExist(){
        Book book = mock(Book.class);
        when(bookService.getBookById(ID)).thenReturn(book);

        Book actualBook = bookRestController.getBookById(ID);

        assertNotNull(actualBook);
        assertEquals(actualBook, book);
        verify(bookService).getBookById(ID);
    }

    @Test
    void deleteBookById_shouldRemoveBook_whenExist(){
        Book book = mock(Book.class);

        bookRestController.addNewBook(book);
        bookRestController.deleteBookById(ID);

        verify(bookService).deleteBookById(ID);
    }

    @Test
    void updateUser_shouldCallService_whenExist(){
        Book book = mock(Book.class);
        Book newBook = mock(Book.class);
        bookRestController.addNewBook(book);

        bookRestController.updateBook(newBook);

        verify(bookService).saveBook(newBook);
    }

    @Test
    void addNewUser_shouldCallService(){
        Book book = mock(Book.class);

        bookRestController.addNewBook(book);

        verify(bookService).saveBook(book);
    }
}