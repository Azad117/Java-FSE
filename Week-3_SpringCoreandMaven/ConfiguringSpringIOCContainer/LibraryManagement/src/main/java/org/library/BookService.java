package org.library;

import java.awt.print.Book;

public class BookService {

    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void displayService()
    {
        System.out.println("Book Service Called");

        bookRepository.displayBook();
    }
}
