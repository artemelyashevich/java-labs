package com.elyashevich.book.validator.impl;

import com.elyashevich.book.entity.BindingType;
import com.elyashevich.book.entity.Book;
import com.elyashevich.book.validator.BookValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.HashSet;

public class BookValidatorImplTest {

    private BookValidator validator;

    @BeforeEach
    public void setUp() {
        validator = new BookValidatorImpl();
    }

    @Test
    public void testValidBook() {
        var authors = new HashSet<String>();
        authors.add("Author 1");
        var book = new Book(1, "Title", authors, "Publisher", LocalDate.of(2022, 1, 1), 300L, 29.99, BindingType.SOFT);
        assertTrue(validator.isValid(book));
    }

    @Test
    public void testNullId() {
        var authors = new HashSet<String>();
        authors.add("Author 1");
        var book = new Book(null, "Title", authors, "Publisher", LocalDate.of(2022, 1, 1), 300L, 29.99, BindingType.SOFT);
        assertFalse(validator.isValid(book));
    }

    @Test
    public void testEmptyTitle() {
        var authors = new HashSet<String>();
        authors.add("Author 1");
        var book = new Book(1, "", authors, "Publisher", LocalDate.of(2022, 1, 1), 300L, 29.99, BindingType.SOFT);
        assertFalse(validator.isValid(book));
    }

    @Test
    public void testNullTitle() {
        var authors = new HashSet<String>();
        authors.add("Author 1");
        var book = new Book(1, null, authors, "Publisher", LocalDate.of(2022, 1, 1), 300L, 29.99, BindingType.SOFT);
        assertFalse(validator.isValid(book));
    }

    @Test
    public void testEmptyAuthors() {
        var authors = new HashSet<String>();
        var book = new Book(1, "Title", authors, "Publisher", LocalDate.of(2022, 1, 1), 300L, 29.99, BindingType.SOFT);
        assertFalse(validator.isValid(book));
    }

    @Test
    public void testNullPublisher() {
        var authors = new HashSet<String>();
        authors.add("Author 1");
        var book = new Book(1, "Title", authors, null, LocalDate.of(2022, 1, 1), 300L, 29.99, BindingType.SOFT);
        assertFalse(validator.isValid(book));
    }

    @Test
    public void testEmptyPublisher() {
        var authors = new HashSet<String>();
        authors.add("Author 1");
        var book = new Book(1, "Title", authors, "", LocalDate.of(2022, 1, 1), 300L, 29.99, BindingType.SOFT);
        assertFalse(validator.isValid(book));
    }

    @Test
    public void testNullPublishedDate() {
        var authors = new HashSet<String>();
        authors.add("Author 1");
        var book = new Book(1, "Title", authors, "Publisher", null, 300L, 29.99, BindingType.SOFT);
        assertFalse(validator.isValid(book));
    }

    @Test
    public void testFuturePublishedDate() {
        var authors = new HashSet<String>();
        authors.add("Author 1");
        var book = new Book(1, "Title", authors, "Publisher", LocalDate.of(2023, 1, 1), 300L, 29.99, BindingType.SOFT);
        assertTrue(validator.isValid(book));
    }

    @Test
    public void testNullBindingType() {
        var authors = new HashSet<String>();
        authors.add("Author 1");
        var book = new Book(1, "Title", authors, "Publisher", LocalDate.of(2022, 1, 1), 300L, 29.99, null);
        assertFalse(validator.isValid(book));
    }
}
