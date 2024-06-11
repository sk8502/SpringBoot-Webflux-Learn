package com.reactive.app.services.impl;

import com.reactive.app.entities.Book;
import com.reactive.app.repository.BookRepository;
import com.reactive.app.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;


    @Override
    public Mono<Book> create(Book book) {
        System.out.println(Thread.currentThread().getName());
        return bookRepository.save(book).doOnNext(data->{
            System.out.println(Thread.currentThread().getName());

        });
    }

    @Override
    public Flux<Book> getAll() {

        return bookRepository.findAll().delayElements(Duration.ofSeconds(2)).log();
    }

    @Override
    public Mono<Book> get(int bookId) {

        return bookRepository.findById(bookId);
    }

    @Override
    public Mono<Book> update(Book book, int bookId) {
        Mono<Book> oldBook=bookRepository.findById(bookId);
      return  oldBook.flatMap(book1 -> {
            book1.setName(book.getName());
            book1.setPublisher(book.getPublisher());
            book1.setAuthor(book.getAuthor());
            book1.setDescription(book.getDescription());

            return bookRepository.save(book1);
        });
//        return oldBook;
    }

    @Override
    public Mono<Void> delete(int bookId) {
        return bookRepository.deleteById(bookId);
    }

    @Override
    public Flux<Book> search(String query) {
        return null;
    }

    @Override
    public Flux<Book> searchBooks(String titleKeyword) {
        return this.bookRepository.searchBookByTitle("%"+titleKeyword+"%");
    }
}
