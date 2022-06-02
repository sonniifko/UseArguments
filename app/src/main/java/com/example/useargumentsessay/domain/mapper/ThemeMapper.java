package com.example.useargumentsessay.domain.mapper;

import com.example.useargumentsessay.domain.Theme;

import org.json.JSONException;
import org.json.JSONObject;

public class ThemeMapper {

    public static Theme themeFromJson(JSONObject jsonObject) {

        Theme theme = null;

        try {
            theme = new Theme(
                    jsonObject.getInt("id"),
                    jsonObject.getString("name")
            );
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return theme;
    }

    public static Theme themeFromBookJson(JSONObject jsonObject) {

        Theme theme = null;

        try {
            theme = new Theme(
                    jsonObject.getJSONObject("themeDto").getInt("id"),
                    jsonObject.getJSONObject("themeDto").getString("name")
            );
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return theme;

    }

}
