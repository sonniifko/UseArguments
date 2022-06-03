package com.example.useargumentsessay.domain.mapper;

import android.util.Log;

import com.example.useargumentsessay.domain.Argument;
import com.example.useargumentsessay.domain.Book;
import com.example.useargumentsessay.domain.Theme;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class BookMapper {

    public static Book bookFromJson(JSONObject jsonObject) {

        Book book = null;

        Log.i("ppppp", "bookFromJson: " + jsonObject);

        try {
            book = new Book(
                    jsonObject.getInt("id"),
                    jsonObject.getString("name"),
                    ThemeMapper.themeFromBookJson(jsonObject),
                    null
            );

            book.setArgumentList(ArgumentMapper.argumentFromBookJson(jsonObject, book));

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return book;
    }



}
