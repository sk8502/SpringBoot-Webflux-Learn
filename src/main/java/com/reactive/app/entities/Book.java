package com.reactive.app.entities;


import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("book_details")
public class Book {



    @Id
    @Column("book_id")
    private int bookId;
    @Column("name")
    private String name;
    @Column("book_desc")
    private  String description;
    @Column("publisher")
    private String publisher;
    @Column("author")
    private String author;


    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Book(int bookId, String author, String publisher, String description, String name) {
        this.bookId = bookId;
        this.author = author;
        this.publisher = publisher;
        this.description = description;
        this.name = name;
    }


    public Book(){

    }



}
