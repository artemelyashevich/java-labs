package com.elyashevich.book.service.impl;

import com.elyashevich.book.repository.BookRepository;
import com.elyashevich.book.entity.Book;
import com.elyashevich.book.service.BookService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;
import java.util.List;

public class BookServiceImpl implements BookService {

    private static final Logger logger = LogManager.getLogger(BookServiceImpl.class);

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findByAuthor(final String author) {
        logger.debug("Attempting to find Books by Author '{}'", author);

        var books = this.bookRepository.findAll().stream()
                .filter(book -> book.getAuthors().contains(author))
                .toList();

        logger.info("Found {} books", books.size());
        return books;
    }

    @Override
    public List<Book> findByPublisher(final String publisher) {
        logger.debug("Attempting to find Books by Publisher '{}'", publisher);

        var books = this.bookRepository.findAll().stream()
                .filter(book -> book.getPublisher().equals(publisher))
                .toList();

        logger.info("Found {} books", books.size());
        return books;
    }

    @Override
    public List<Book> findByPublishDate(final LocalDateTime publishDate) {
        logger.debug("Attempting to find Books by Publish Date '{}'", publishDate);

        var books = this.bookRepository.findAll().stream()
                .filter(book -> book.getPublishedDate().isBefore(publishDate.toLocalDate()))
                .toList();

        logger.info("Found {} books", books.size());
        return books;
    }

    @Override
    public void create(final Book book) {
        logger.debug("Attempting to add Book '{}'", book);

        this.bookRepository.addBook(book);

        logger.info("Added Book '{}'", book);
    }
}
