package com.elyashevich.book.validator;

import com.elyashevich.book.entity.Book;

/**
 * Interface for validating Book objects.
 */
public interface BookValidator {

    /**
     * Checks if the given book is valid.
     *
     * @param book The book to be validated.
     * @return True if the book is valid, otherwise false.
     */
    boolean isValid(final Book book);
}
