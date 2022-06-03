package com.example.useargumentsessay.fragment;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.useargumentsessay.R;
import com.example.useargumentsessay.adapter.ThemeSpinnerAdapter;
import com.example.useargumentsessay.domain.Book;
import com.example.useargumentsessay.domain.Theme;
import com.example.useargumentsessay.nodb.NoDb;
import com.example.useargumentsessay.rest.UseApiVolley;

public class SettingBook extends Fragment {

    private AppCompatSpinner theme_spinner_book;
    private ThemeSpinnerAdapter themeSpinnerAdapter;
    private EditText addBook;
    private AppCompatButton btnAddBook;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_setting_book, container, false);

        theme_spinner_book = view.findViewById(R.id.theme_spinner_book);
        btnAddBook = view.findViewById(R.id.commit_book);
        addBook = view.findViewById(R.id.add_book);

        themeSpinnerAdapter = new ThemeSpinnerAdapter(getContext(), NoDb.THEME_LIST);
        theme_spinner_book.setAdapter(themeSpinnerAdapter);

        btnAddBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new UseApiVolley(getContext()).addBook(
                        new Book(
                                addBook.getText().toString(),
                                ((Theme) theme_spinner_book.getSelectedItem())
                        )
                );

                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .remove(SettingBook.this)
                        .addToBackStack(null)
                        .commit();
            }
        });
        return view;
    }
}