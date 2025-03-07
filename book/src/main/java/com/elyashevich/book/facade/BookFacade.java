package com.elyashevich.book.facade;

import com.elyashevich.book.controller.BookController;
import com.elyashevich.book.create.BookRepository;
import com.elyashevich.book.create.impl.BookRepositoryImpl;
import com.elyashevich.book.entity.BindingType;
import com.elyashevich.book.entity.Book;
import com.elyashevich.book.exception.ValidationException;
import com.elyashevich.book.service.BookService;
import com.elyashevich.book.service.impl.BookServiceImpl;
import com.elyashevich.book.validator.BookValidator;
import com.elyashevich.book.validator.impl.BookValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

public class BookFacade {

    private static final Logger logger = LogManager.getLogger(BookFacade.class);
    private final BookRepository bookRepository;
    private final BookService bookService;
    private final BookValidator bookValidator;
    private final BookController bookController;

    public BookFacade() {
        this.bookRepository = BookRepositoryImpl.INSTANCE;
        this.bookService = new BookServiceImpl(bookRepository);
        this.bookValidator = BookValidatorImpl.INSTANCE;
        this.bookController = new BookController(bookService, bookValidator);
    }

    public void execute() {
        var booksByAuthor = this.bookController.findByAuthor("Author 1");
        var booksByPublisher = this.bookController.findByPublisher("Publisher 1");
        var booksByPublishDate = this.bookController.findByPublishDate(
                LocalDateTime.of(
                        LocalDate.of(2022, 2, 28),
                        LocalTime.of(5, 12)
                        )
        );
        var authors1 = new HashSet<String>();
        authors1.add("Author 1");
        authors1.add("Co-Author 1");

        var authors2 = new HashSet<String>();
        authors2.add("Author 2");
        authors2.add("Co-Author 2");

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
            try {
                this.bookController.create(book);
            } catch (ValidationException e) {
                logger.warn("Something went wrong", e);
            }
        }

        logger.info("Books by author: ");
        booksByAuthor.forEach(logger::info);

        logger.info("Books by publisher: ");
        booksByPublisher.forEach(logger::info);

        logger.info("Books by publish date: ");
        booksByPublishDate.forEach(logger::info);

        var books = this.bookRepository.findAll();

        logger.info("All Books: ");
        for (Book book : books) {
            System.out.println(book);
            logger.info(book);
        }
    }
}
