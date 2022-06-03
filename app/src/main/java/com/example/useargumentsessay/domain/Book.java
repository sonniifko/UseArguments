package com.example.useargumentsessay.domain;

import android.graphics.Bitmap;
import android.media.Image;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Book implements Serializable {

    private static Bitmap image;

    private int id;

    private String name;

    private Theme theme;

    private List<Argument> argumentList;

    public Book(int id, String name, Theme theme, List<Argument> argumentList) {
        this.id = id;
        this.name = name;
        this.theme = theme;
        this.argumentList = argumentList;
    }

    public Book(String name, Theme theme, List<Argument> argumentList) {
        this.name = name;
        this.theme = theme;
        this.argumentList = argumentList;
    }

    public Book(String name, Theme theme) {
        this.name = name;
        this.theme = theme;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Theme getTheme() {
        return theme;
    }

    public List<Argument> getArgument() {
        return argumentList;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id && Objects.equals(name, book.name) && Objects.equals(theme, book.theme) && Objects.equals(argumentList, book.argumentList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, theme, argumentList);
    }

    public void setArgumentList(List<Argument> argumentList) {
        this.argumentList = argumentList;
    }
}
