package com.elyashevich.book.create.impl;

import com.elyashevich.book.create.BookRepository;
import com.elyashevich.book.entity.BindingType;
import com.elyashevich.book.entity.Book;

import java.time.LocalDate;
import java.util.*;

public class BookRepositoryImpl implements BookRepository {

    public final static BookRepositoryImpl INSTANCE = new BookRepositoryImpl();
    private final List<Book> books = new ArrayList<Book>();

    {
        var authors1 = new HashSet<String>();
        authors1.add("Author 1");
        authors1.add("Co-Author 1");

        var authors2 = new HashSet<String>();
        authors2.add("Author 2");
        authors2.add("Co-Author 2");

        // Repeat for up to 15 authors
        for (int i = 1; i <= 15; i++) {
            Set<String> authors = new HashSet<>();
            authors.add("Author " + i);
            authors.add("Co-Author " + i);

            Book book = new Book(
                    i,
                    "Title " + i,
                    authors,
                    "Publisher " + i,
                    LocalDate.of(2022, i % 12 + 1, i % 28 + 1),
                    100L + i * 10,
                    9.99 + i,
                    i % 2 == 0 ? BindingType.SOFT : BindingType.HARDCOVER
            );
            this.books.add(book);
        }
    }

    @Override
    public void createBook(final Book book) {
        this.books.add(book);
    }

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(this.books);
    }
}
