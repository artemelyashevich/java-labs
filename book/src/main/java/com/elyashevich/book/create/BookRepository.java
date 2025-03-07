package com.elyashevich.book.create;

import com.elyashevich.book.entity.Book;

import java.util.List;

/**
 * Interface for BookRepository operations.
 */
public interface BookRepository {

    /**
     * Creates a new book entry.
     *
     * @param book The book to be created.
     */
    void addBook(final Book book);

    /**
     * Finds all books in the repository.
     *
     * @return A list of all books.
     */
    List<Book> findAll();
}

