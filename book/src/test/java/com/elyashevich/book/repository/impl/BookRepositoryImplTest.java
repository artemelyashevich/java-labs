package com.elyashevich.book.repository.impl;

import static org.junit.jupiter.api.Assertions.*;

import com.elyashevich.book.entity.BindingType;
import com.elyashevich.book.entity.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashSet;

class BookRepositoryImplTest {

    private BookRepositoryImpl bookRepository;

    @BeforeEach
    void setUp() {
        // Arrange
        bookRepository = new BookRepositoryImpl();
    }

    @Test
    void testInitialBooksCount() {
        // Arrange
        var books = bookRepository.findAll();

        // Act
        var bookCount = books.size();

        // Assert
        assertEquals(15, bookCount);
    }

    @Test
    void testCreateBook() {
        // Arrange
        var authors = new HashSet<String>();
        authors.add("Author 16");
        authors.add("Co-Author 16");

        var book = new Book(16, "Title 16", authors, "Publisher 16", LocalDate.of(2022, 1, 16), 260L, 25.99, BindingType.HARDCOVER);

        // Act
        bookRepository.addBook(book);
        var books = bookRepository.findAll();

        // Assert
        assertAll(
                () -> assertEquals(16, books.size()),
                () -> assertTrue(books.contains(book))
        );
    }

    @Test
    void testFindAllBooks() {
        // Arrange
        var books = bookRepository.findAll();

        // Act & Assert
        assertAll(
                () -> assertNotNull(books),
                () -> assertEquals(15, books.size())
        );
    }

    @Test
    void testFindBookById() {
        // Arrange
        var books = bookRepository.findAll();

        // Act
        var book = books.get(0);

        // Assert
        assertEquals(1, book.getId());
    }

    @Test
    void testBookAuthors() {
        // Arrange
        var books = bookRepository.findAll();
        var book = books.get(0);

        // Act
        var authors = book.getAuthors();

        // Assert
        assertAll(
                () -> assertTrue(authors.contains("Author 1")),
                () -> assertTrue(authors.contains("Co-Author 1"))
        );
    }

    @Test
    void testBookPublisher() {
        // Arrange
        var books = bookRepository.findAll();
        var book = books.get(0);

        // Act
        var publisher = book.getPublisher();

        // Assert
        assertEquals("Publisher 1", publisher);
    }

    @Test
    void testBookPublishedDate() {
        // Arrange
        var books = bookRepository.findAll();
        var book = books.get(0);

        // Act
        var publishedDate = book.getPublishedDate();

        // Assert
        assertEquals(LocalDate.of(2022, 2, 2), publishedDate);
    }

    @Test
    void testBookPages() {
        // Arrange
        var books = bookRepository.findAll();
        var book = books.get(0);

        // Act
        var pages = book.getPages();

        // Assert
        assertEquals(110L, pages);
    }

    @Test
    void testBookPrice() {
        // Arrange
        var books = bookRepository.findAll();
        var book = books.get(0);

        // Act
        var price = book.getPrice();

        // Assert
        assertEquals(10.99, price);
    }

    @Test
    void testBookBindingType() {
        // Arrange
        var books = bookRepository.findAll();
        var book = books.get(0);

        // Act
        var bindingType = book.getBindingType();

        // Assert
        assertEquals(BindingType.HARDCOVER, bindingType);
    }
}
