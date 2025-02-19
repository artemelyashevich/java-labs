package com.elyashevich.book.facade;

import com.elyashevich.book.controller.BookController;
import com.elyashevich.book.create.BookRepository;
import com.elyashevich.book.create.impl.BookRepositoryImpl;
import com.elyashevich.book.entity.Book;
import com.elyashevich.book.service.BookService;
import com.elyashevich.book.service.impl.BookServiceImpl;
import com.elyashevich.book.validator.BookValidator;
import com.elyashevich.book.validator.impl.BookValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class BookFacade {

    private static final Logger logger = LogManager.getLogger(BookFacade.class);
    private final BookRepository bookRepository;
    private final BookService bookService;
    private final BookValidator bookValidator;
    private final BookController bookController;

    public BookFacade() {
        this.bookRepository = new BookRepositoryImpl();
        this.bookService = new BookServiceImpl(bookRepository);
        this.bookValidator = new BookValidatorImpl();
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
