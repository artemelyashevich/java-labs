package com.elyashevich.book.service;

import com.elyashevich.book.entity.Book;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Interface for BookService operations.
 */
public interface BookService {

    /**
     * Finds books by the given author.
     *
     * @param author The author's name to search for.
     * @return A list of books written by the specified author.
     */
    List<Book> findByAuthor(final String author);

    /**
     * Finds books by the given publisher.
     *
     * @param publisher The publisher's name to search for.
     * @return A list of books published by the specified publisher.
     */
    List<Book> findByPublisher(final String publisher);

    /**
     * Finds books by the given publish date.
     *
     * @param publishDate The publish date to search for.
     * @return A list of books published on the specified date.
     */
    List<Book> findByPublishDate(final LocalDateTime publishDate);

    /**
     * Creates a new book entry.
     *
     * @param book The book to be created.
     */
    void create(final Book book);
}
