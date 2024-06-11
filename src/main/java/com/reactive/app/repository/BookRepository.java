package com.reactive.app.repository;

import com.reactive.app.entities.Book;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface BookRepository extends ReactiveCrudRepository<Book,Integer> {

    public Mono<Book> findByName(String name);
    public Flux<Book> findByAuthor(String author);

    public Flux<Book> findByNameAndAuthor(String name,String author);

    @Query("select * from book_details where name  LIKE :title")
    Flux<Book> searchBookByTitle(String title);
}
