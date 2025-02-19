package com.elyashevich.book.service;

import com.elyashevich.book.entity.Book;

import java.time.LocalDateTime;
import java.util.List;

public interface BookService {

    List<Book> findByAuthor(final String author);

    List<Book> findByPublisher(final String publisher);

    List<Book> findByPublishDate(final LocalDateTime publishDate);

    void create(final Book book);
}
