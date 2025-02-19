package com.elyashevich.book.validator.impl;

import com.elyashevich.book.entity.Book;
import com.elyashevich.book.validator.BookValidator;

import java.time.LocalDateTime;

public class BookValidatorImpl implements BookValidator {

    @Override
    public boolean isValid(final Book book) {
        return (book.getId() != null)
                && (!book.getAuthors().isEmpty())
                && (book.getTitle() != null && !book.getTitle().isEmpty())
                && (book.getPages() != null && book.getPages() > 0)
                && (book.getBindingType() != null)
                && (book.getPublisher() != null && !book.getPublisher().isEmpty())
                && (book.getPublishedDate() != null && book.getPublishedDate().isBefore(LocalDateTime.now().toLocalDate()))
                && (book.getAuthors() != null && !book.getAuthors().isEmpty());
    }
}
