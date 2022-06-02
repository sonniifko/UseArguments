package com.example.useargumentsessay.domain;

public class Argument {

    private int id;

    private String content;

    public Book book;

    public Argument(int id, String content, Book book) {
        this.id = id;
        this.content = content;
        this.book = book;
    }

    public Argument(String content) {
        this.content = content;
        this.book = book;

    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public Book getBook() {
        return book;
    }
}
