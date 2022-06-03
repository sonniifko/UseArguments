package com.example.useargumentsessay.domain;

import java.io.Serializable;
import java.util.Objects;

public class Theme implements Serializable {

    private int id;

    private String themeName;

    public Theme(int id, String themeName) {

        this.id = id;
        this.themeName = themeName;
    }

    public Theme(String themeName) {

        this.themeName = themeName;
    }

    public int getId() {

        return id;
    }

    public String getThemeName() {

        return themeName;
    }

    @Override
    public String toString() {
        return themeName ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Theme theme = (Theme) o;
        return id == theme.id && Objects.equals(themeName, theme.themeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, themeName);
    }
}
