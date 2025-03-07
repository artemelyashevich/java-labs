package com.elyashevich.book.validator.impl;

import com.elyashevich.book.entity.BindingType;
import com.elyashevich.book.entity.Book;
import com.elyashevich.book.validator.BookValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.HashSet;

class BookValidatorImplTest {

    private BookValidator validator;

    @BeforeEach
    void setUp() {
        // Arrange
        validator = new BookValidatorImpl();
    }

    @Test
    void testValidBook() {
        // Arrange
        var authors = new HashSet<String>();
        authors.add("Author 1");
        var book = new Book(1, "Title", authors, "Publisher", LocalDate.of(2022, 1, 1), 300L, 29.99, BindingType.SOFT);

        // Act
        boolean result = validator.isValid(book);

        // Assert
        assertTrue(result);
    }

    @Test
    void testNullId() {
        // Arrange
        var authors = new HashSet<String>();
        authors.add("Author 1");
        var book = new Book(null, "Title", authors, "Publisher", LocalDate.of(2022, 1, 1), 300L, 29.99, BindingType.SOFT);

        // Act
        boolean result = validator.isValid(book);

        // Assert
        assertFalse(result);
    }

    @Test
    void testEmptyTitle() {
        // Arrange
        var authors = new HashSet<String>();
        authors.add("Author 1");
        var book = new Book(1, "", authors, "Publisher", LocalDate.of(2022, 1, 1), 300L, 29.99, BindingType.SOFT);

        // Act
        boolean result = validator.isValid(book);

        // Assert
        assertFalse(result);
    }

    @Test
    void testNullTitle() {
        // Arrange
        var authors = new HashSet<String>();
        authors.add("Author 1");
        var book = new Book(1, null, authors, "Publisher", LocalDate.of(2022, 1, 1), 300L, 29.99, BindingType.SOFT);

        // Act
        boolean result = validator.isValid(book);

        // Assert
        assertFalse(result);
    }

    @Test
    void testEmptyAuthors() {
        // Arrange
        var authors = new HashSet<String>();
        var book = new Book(1, "Title", authors, "Publisher", LocalDate.of(2022, 1, 1), 300L, 29.99, BindingType.SOFT);

        // Act
        boolean result = validator.isValid(book);

        // Assert
        assertFalse(result);
    }

    @Test
    void testNullPublisher() {
        // Arrange
        var authors = new HashSet<String>();
        authors.add("Author 1");
        var book = new Book(1, "Title", authors, null, LocalDate.of(2022, 1, 1), 300L, 29.99, BindingType.SOFT);

        // Act
        boolean result = validator.isValid(book);

        // Assert
        assertFalse(result);
    }

    @Test
    void testEmptyPublisher() {
        // Arrange
        var authors = new HashSet<String>();
        authors.add("Author 1");
        var book = new Book(1, "Title", authors, "", LocalDate.of(2022, 1, 1), 300L, 29.99, BindingType.SOFT);

        // Act
        boolean result = validator.isValid(book);

        // Assert
        assertFalse(result);
    }

    @Test
    void testNullPublishedDate() {
        // Arrange
        var authors = new HashSet<String>();
        authors.add("Author 1");
        var book = new Book(1, "Title", authors, "Publisher", null, 300L, 29.99, BindingType.SOFT);

        // Act
        boolean result = validator.isValid(book);

        // Assert
        assertFalse(result);
    }

    @Test
    void testFuturePublishedDate() {
        // Arrange
        var authors = new HashSet<String>();
        authors.add("Author 1");
        var book = new Book(1, "Title", authors, "Publisher", LocalDate.of(2023, 1, 1), 300L, 29.99, BindingType.SOFT);

        // Act
        boolean result = validator.isValid(book);

        // Assert
        assertTrue(result);
    }

    @Test
    void testNullBindingType() {
        // Arrange
        var authors = new HashSet<String>();
        authors.add("Author 1");
        var book = new Book(1, "Title", authors, "Publisher", LocalDate.of(2022, 1, 1), 300L, 29.99, null);

        // Act
        boolean result = validator.isValid(book);

        // Assert
        assertFalse(result);
    }
}
