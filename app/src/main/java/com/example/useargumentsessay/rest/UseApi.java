package com.example.useargumentsessay.rest;

import com.example.useargumentsessay.domain.Book;
import com.example.useargumentsessay.domain.Theme;

public interface UseApi {

    void fillTheme();

    void fillBook();

    void addBook(Book book);

    void addTheme(Theme theme);


    void updateBook(
            int id,
            String newBookName,
            String newThemeName,
            String argumentList
    );

    void deleteBook(int id);

}
