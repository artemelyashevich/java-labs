package com.elyashevich.book.validator;

import com.elyashevich.book.entity.Book;

public interface BookValidator {

    boolean isValid(final Book book);
}
