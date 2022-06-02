package com.example.useargumentsessay.domain.mapper;

import com.example.useargumentsessay.domain.Argument;
import com.example.useargumentsessay.domain.Book;
import com.example.useargumentsessay.domain.Theme;

import org.json.JSONException;
import org.json.JSONObject;

public class ArgumentMapper {

    public static Argument argumentFromJson(JSONObject jsonObject) {

        Argument argument = null;

        try {
            argument = new Argument(
                    jsonObject.getInt("id"),
                    jsonObject.getString("nameArgument"),
                    BookMapper.bookFromJson(jsonObject)
            );
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return argument;
    }

    public static Argument argumentFromBookJson(JSONObject jsonObject) {

        Argument argument = null;

        try {
            argument = new Argument(
                    jsonObject.getJSONObject("argumentDto").getInt("id"),
                    jsonObject.getJSONObject("argumentDto").getString("content"),
                    null
            );
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return argument;

    }
}
