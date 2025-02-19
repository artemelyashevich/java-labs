package com.elyashevich.book;

import com.elyashevich.book.facade.BookFacade;

public class Application {

    public static void main(String[] args) {
        var facade = new BookFacade();
        facade.execute();
    }
}
