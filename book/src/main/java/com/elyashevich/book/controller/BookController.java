package com.elyashevich.book.controller;

import com.elyashevich.book.entity.Book;
import com.elyashevich.book.exception.ValidationException;
import com.elyashevich.book.service.BookService;
import com.elyashevich.book.validator.BookValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;
import java.util.List;

public class BookController {

    private static final Logger logger = LogManager.getLogger(BookController.class);

    private final BookService bookService;
    private final BookValidator bookValidator;

    public BookController(BookService bookService, BookValidator bookValidator) {
        this.bookService = bookService;
        this.bookValidator = bookValidator;
    }

    public void create(final Book book) throws ValidationException {
        if (!this.bookValidator.isValid(book)) {
            logger.warn("Invalid book");
            throw new ValidationException("Invalid book");
        }
        this.bookService.create(book);
    }

    public List<Book> findByAuthor(final String author){
        return this.bookService.findByAuthor(author);
    }

    public List<Book> findByPublisher(final String publisher){
        return this.bookService.findByPublisher(publisher);
    }

    public List<Book> findByPublishDate(final LocalDateTime publishDate){
        return this.bookService.findByPublishDate(publishDate);
    }
}
