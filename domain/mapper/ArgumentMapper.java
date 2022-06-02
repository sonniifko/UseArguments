package com.example.useargumentsessay.domain.mapper;

import android.util.Log;

import com.example.useargumentsessay.domain.Argument;
import com.example.useargumentsessay.domain.Book;
import com.example.useargumentsessay.domain.Theme;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

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

    public static List<Argument> argumentFromBookJson(JSONObject jsonObject, Book book) throws JSONException {

        List<Argument> arguments = new ArrayList<>();
//
//        try {
//            argument = new Argument(
//                    jsonObject.getJSONObject("argumentDtoList").getInt("id"),
//                    jsonObject.getJSONObject("argumentDtoList").getString("content"),
//                    BookMapper.bookFromJson(jsonObject)
//                    );
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }

        JSONArray argumentDtoList = jsonObject.getJSONArray("argumentDtoList");

        for (int i = 0; i < argumentDtoList.length(); ++i ) {

            JSONObject jsonArgument = argumentDtoList.getJSONObject(i);

            arguments.add(new Argument(
                    jsonArgument.getInt("id"),
                    jsonArgument.getString("content"),
                    book
            ));
        }

        return arguments;

    }
}
