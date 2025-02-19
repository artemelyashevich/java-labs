package com.elyashevich.book.create;

import com.elyashevich.book.entity.Book;

import java.util.List;

public interface BookRepository {

    void createBook(final Book book);

    List<Book> findAll();
}
