package com.example.useargumentsessay.domain;

import android.graphics.Bitmap;
import android.media.Image;

import java.io.Serializable;
import java.util.List;

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

    public static Bitmap getImage() {
        return image;
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
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", theme=" + theme +
                ", argument=" + argumentList +
                '}';
    }
}
