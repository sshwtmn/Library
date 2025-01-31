package org.example.library.services;


import lombok.AllArgsConstructor;
import org.example.library.models.Book;
import org.example.library.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class BookService {

    private BookRepository bookRepository;

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public Book getBook(Long id) {
        Optional<Book> byId = bookRepository.findById(id);
        return byId.orElse(null);
    }
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

}

