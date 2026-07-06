package org.library.librarymanagement.controller;

import org.library.librarymanagement.entity.Book;
import org.library.librarymanagement.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @PostMapping
    public Book addBook(@RequestBody Book book)
    {
        return bookRepository.save(book);
    }

    @GetMapping
    public List<Book> getBooks()
    {
        return bookRepository.findAll();
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id)
    {
        return bookRepository.findById(id).orElse(null);
    }



}
