package com.hexaware.APICodingChallenge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.APICodingChallenge.Entities.Book;
import com.hexaware.APICodingChallenge.Repository.BookRepository;
import com.hexaware.APICodingChallenge.Service.BookService;

import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class BookServiceTest {

    @Mock
    private BookRepository bookRepo;

    @InjectMocks
    private BookService bookService;

    @Test
    void addbooktest() {
        Book book = new Book(1L, "The Great Gatsby", "F. Scott Fitzgerald", 1925);
        when(bookRepo.save(book)).thenReturn(book);
        Book result = bookService.addbook(book);
        assertEquals(book, result);
    }

    @Test
    void getallbookstest() {
        Book book1 = new Book(1L, "1984", "George Orwell", 1949);
        Book book2 = new Book(2L, "Brave New World", "Aldous Huxley", 1932);
        List<Book> books = Arrays.asList(book1, book2);
        when(bookRepo.findAll()).thenReturn(books);
        List<Book> result = bookService.getAllbooks();
        assertTrue(result.contains(book1));
        assertTrue(result.contains(book2));
    }

    @Test
    void removeBooktest() {
        Book book = new Book(1L, "The Catcher in the Rye", "J.D. Salinger", 1951);
        when(bookRepo.findById(1L)).thenReturn(Optional.of(book));
        String result = bookService.deleteBook(1L);
        assertEquals("Deleted", result);
        verify(bookRepo).findById(1L);
    }

    @Test
    void updateBooktest() {
        Book book = new Book(1L, "Old Title", "Author", 1990);
        when(bookRepo.findById(1L)).thenReturn(Optional.of(book));
        book.setTitle("New Title");
        when(bookRepo.save(book)).thenReturn(book);
        Book result = bookService.updateBook(1L, book);
        assertNotNull(result);
        assertEquals("New Title", result.getTitle());
        verify(bookRepo).save(book);
        
    }

    @Test
    void getBookByisbntest() {
        Book book = new Book(1L, "Moby Dick", "Herman Melville", 1851);
        when(bookRepo.findById(1L)).thenReturn(Optional.of(book));
        Book result = bookService.getbookbyISBN(1L);
        assertEquals(book, result);
    }

   
}