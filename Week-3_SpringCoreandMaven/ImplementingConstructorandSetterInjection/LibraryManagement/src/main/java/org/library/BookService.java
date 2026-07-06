package org.library;

public class BookService {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {

        System.out.println("Book Service Constructor");
        this.bookRepository = bookRepository;
    }

    public void setBookRepository(BookRepository bookRepository) {
        System.out.println("Book Service setBookRepository");
        this.bookRepository = bookRepository;
    }

    public void diaplayService()
    {
        System.out.println("Book Service diaplayService");

        bookRepository.displayBook();
    }

}
