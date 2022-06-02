package com.example.useargumentsessay.domain;

import java.io.Serializable;

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
        return "Theme{" +
                "id=" + id +
                ", themeName='" + themeName + '\'' +
                '}';
    }
}
