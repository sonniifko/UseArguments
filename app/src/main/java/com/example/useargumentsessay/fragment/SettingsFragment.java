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
import com.example.useargumentsessay.adapter.BookSpinnerAdapter;
import com.example.useargumentsessay.adapter.ThemeSpinnerAdapter;
import com.example.useargumentsessay.domain.Argument;
import com.example.useargumentsessay.domain.Book;
import com.example.useargumentsessay.nodb.NoDb;
import com.example.useargumentsessay.rest.UseApiVolley;

public class SettingsFragment extends Fragment {

    private AppCompatSpinner spTheme, spBook;

    private ThemeSpinnerAdapter themeSpinnerAdapter;

    private BookSpinnerAdapter bookSpinnerAdapter;

    private EditText etArgumentName;

    private AppCompatButton btnAdd;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_settings, container, false);

        spTheme = view.findViewById(R.id.theme_spinner);

        spBook = view.findViewById(R.id.book_spinner);

        btnAdd = view.findViewById(R.id.commit);

        etArgumentName = view.findViewById(R.id.add_arg);


        themeSpinnerAdapter = new ThemeSpinnerAdapter(getContext(), NoDb.THEME_LIST);

        bookSpinnerAdapter = new BookSpinnerAdapter(getContext(), NoDb.BOOK_LIST);

        spTheme.setAdapter(themeSpinnerAdapter);

        spBook.setAdapter(bookSpinnerAdapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new UseApiVolley(getContext()).addArgument(
                        new Argument(
                                etArgumentName.getText().toString(),
                                ((Book) spBook.getSelectedItem())
                        )
                );

                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .remove(SettingsFragment.this)
                        .commit();
            }
        });

        return view;
    }
}