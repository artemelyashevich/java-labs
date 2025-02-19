package com.elyashevich.book.create.impl;

import static org.junit.jupiter.api.Assertions.*;

import com.elyashevich.book.entity.BindingType;
import com.elyashevich.book.entity.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class BookRepositoryImplTest {

    private BookRepositoryImpl bookRepository;

    @BeforeEach
    public void setUp() {
        bookRepository = new BookRepositoryImpl();
    }

    @Test
    public void testInitialBooksCount() {
        List<Book> books = bookRepository.findAll();
        assertEquals(15, books.size());
    }

    @Test
    public void testCreateBook() {
        Set<String> authors = new HashSet<>();
        authors.add("Author 16");
        authors.add("Co-Author 16");

        Book book = new Book(16, "Title 16", authors, "Publisher 16", LocalDate.of(2022, 1, 16), 260L, 25.99, BindingType.HARDCOVER);
        bookRepository.createBook(book);

        List<Book> books = bookRepository.findAll();
        assertEquals(16, books.size());
        assertTrue(books.contains(book));
    }

    @Test
    public void testFindAllBooks() {
        List<Book> books = bookRepository.findAll();
        assertNotNull(books);
        assertEquals(15, books.size());
    }

    @Test
    public void testFindBookById() {
        List<Book> books = bookRepository.findAll();
        Book book = books.get(0);
        assertEquals(1, book.getId());
    }

    @Test
    public void testBookAuthors() {
        List<Book> books = bookRepository.findAll();
        Book book = books.get(0);
        Set<String> authors = book.getAuthors();
        assertTrue(authors.contains("Author 1"));
        assertTrue(authors.contains("Co-Author 1"));
    }

    @Test
    public void testBookPublisher() {
        List<Book> books = bookRepository.findAll();
        Book book = books.get(0);
        assertEquals("Publisher 1", book.getPublisher());
    }

    @Test
    public void testBookPublishedDate() {
        List<Book> books = bookRepository.findAll();
        Book book = books.get(0);
        assertEquals(LocalDate.of(2022, 2, 2), book.getPublishedDate());
    }

    @Test
    public void testBookPages() {
        List<Book> books = bookRepository.findAll();
        Book book = books.get(0);
        assertEquals(110L, book.getPages());
    }

    @Test
    public void testBookPrice() {
        List<Book> books = bookRepository.findAll();
        Book book = books.get(0);
        assertEquals(10.99, book.getPrice());
    }

    @Test
    public void testBookBindingType() {
        List<Book> books = bookRepository.findAll();
        Book book = books.get(0);
        assertEquals(BindingType.HARDCOVER, book.getBindingType());
    }
}
