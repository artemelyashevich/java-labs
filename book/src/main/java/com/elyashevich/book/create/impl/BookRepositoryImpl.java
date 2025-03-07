package com.elyashevich.book.create.impl;

import com.elyashevich.book.create.BookRepository;
import com.elyashevich.book.entity.BindingType;
import com.elyashevich.book.entity.Book;

import java.time.LocalDate;
import java.util.*;

public class BookRepositoryImpl implements BookRepository {

    public final static BookRepositoryImpl INSTANCE = new BookRepositoryImpl();
    private final List<Book> books = new ArrayList<Book>();

    @Override
    public void addBook(final Book book) {
        this.books.add(book);
    }

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(this.books);
    }
}
