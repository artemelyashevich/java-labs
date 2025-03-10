package com.elyashevich.book.repository.impl;

import com.elyashevich.book.repository.BookRepository;
import com.elyashevich.book.entity.Book;

import java.util.*;

public class BookRepositoryImpl implements BookRepository {

    public final static BookRepositoryImpl INSTANCE = new BookRepositoryImpl();
    private final List<Book> books = new ArrayList<>();

    @Override
    public void addBook(final Book book) {
        this.books.add(book);
    }

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(this.books);
    }
}
