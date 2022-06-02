package com.example.useargumentsessay.rest;

import android.content.Context;
import android.util.Log;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.useargumentsessay.Fragment.BookFragment;
import com.example.useargumentsessay.MainActivity;
import com.example.useargumentsessay.domain.Argument;
import com.example.useargumentsessay.domain.Book;
import com.example.useargumentsessay.domain.Theme;
import com.example.useargumentsessay.domain.mapper.ArgumentMapper;
import com.example.useargumentsessay.domain.mapper.BookMapper;
import com.example.useargumentsessay.domain.mapper.ThemeMapper;
import com.example.useargumentsessay.nodb.NoDb;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class UseApiVolley implements UseApi{

    public static final String API_TEST = "API_TEST";

    private final Context context;

    public static final String BASE_URL = "http://192.168.1.136:8081";

    private Response.ErrorListener errorListener;

    public UseApiVolley(Context context) {

        this.context = context;

        errorListener = error -> Log.d(API_TEST, error.toString());
    }

    @Override
    public void fillArgument() {

        RequestQueue requestQueue = Volley.newRequestQueue(context);

        String url = BASE_URL + "/argument";

        JsonArrayRequest arrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        NoDb.ARGUMENT_LIST.clear();

                        try {

                            for (int i = 0; i < response.length(); i++) {

                                JSONObject jsonObject = response.getJSONObject(i);

                                Argument argument = ArgumentMapper.argumentFromJson(jsonObject);

//                                Log.e("mapper", argument.toString() + " ");

                                NoDb.ARGUMENT_LIST.add(argument);
                            }

                            Log.d(API_TEST, NoDb.ARGUMENT_LIST.toString());
                        } catch (JSONException e) {
                            e.printStackTrace();

                        }
                    }
                },

                errorListener
        );

        requestQueue.add(arrayRequest);

    }

    @Override
    public void fillBook() {

        RequestQueue requestQueue = Volley.newRequestQueue(context);

        String url = BASE_URL + "/book";

        JsonArrayRequest arrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        NoDb.BOOK_LIST.clear();

                        try {

                            for (int i = 0; i < response.length(); i++) {

                                JSONObject jsonObject = response.getJSONObject(i);

                                Book book = BookMapper.bookFromJson(jsonObject);

                                Log.e("mapper", book.toString() + " ");

                                NoDb.BOOK_LIST.add(book);
                            }

                            Log.d(API_TEST, NoDb.BOOK_LIST.toString());
                        } catch (JSONException e) {
                                e.printStackTrace();

                        }
                    }
                },

                errorListener
        );

        requestQueue.add(arrayRequest);
    }

    @Override
    public void fillTheme() {

        RequestQueue requestQueue = Volley.newRequestQueue(context);

        String url = BASE_URL + "/theme";

        JsonArrayRequest arrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        NoDb.THEME_LIST.clear();

                        try {

                            for (int i = 0; i < response.length(); i++) {

                                JSONObject jsonObject = response.getJSONObject(i);

                                Theme theme = ThemeMapper.themeFromJson(jsonObject);

                                NoDb.THEME_LIST.add(theme);
                            }

                            ((MainActivity)context).updateThemeAdapter();

                            Log.d(API_TEST, NoDb.THEME_LIST.toString());
                        } catch (JSONException e) {
                            e.printStackTrace();

                        }
                    }
                },

                errorListener
        );

        requestQueue.add(arrayRequest);

    }

    @Override
    public void addBook(Book book) {

        RequestQueue requestQueue = Volley.newRequestQueue(context);

        String url = BASE_URL + "/book";

        StringRequest request = new StringRequest(
                Request.Method.POST,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        fillBook();
                        Log.d(API_TEST, response);
                    }
                },
                errorListener
        ) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<>();

                params.put("nameBook", book.getName());
                params.put("nameTheme", book.getTheme().getThemeName());

                return params;
            }
        };

        requestQueue.add(request);
    }

    @Override
    public void addTheme(Theme theme) {

        RequestQueue requestQueue = Volley.newRequestQueue(context);

        String url = BASE_URL + "/theme";

        StringRequest request = new StringRequest(
                Request.Method.POST,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        fillTheme();
                        Log.d(API_TEST, response);
                    }
                },
                errorListener
        ) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<>();

                params.put("nameTheme", theme.getThemeName());

                return params;
            }
        };

        requestQueue.add(request);
    }

    @Override
    public void addArgument(Argument argument) {

        RequestQueue requestQueue = Volley.newRequestQueue(context);

        String url = BASE_URL + "/argument";

        StringRequest request = new StringRequest(
                Request.Method.POST,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        fillArgument();
                        Log.d(API_TEST, response);
                    }
                },
                errorListener
        ) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<>();

                params.put("content", argument.getContent());
                params.put("nameBook", argument.getBook().getName());

                return params;
            }
        };

        requestQueue.add(request);
    }

    @Override
    public void updateBook(int id, String newBookName, String newThemeName, String argumentList) {

    }

    @Override
    public void deleteBook(int id) {

    }
};


