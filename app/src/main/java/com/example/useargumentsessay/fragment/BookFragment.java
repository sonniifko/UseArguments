package com.example.useargumentsessay.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.useargumentsessay.R;
import com.example.useargumentsessay.adapter.BookAdapter;
import com.example.useargumentsessay.domain.Book;
import com.example.useargumentsessay.domain.Theme;
import com.example.useargumentsessay.nodb.NoDb;

import java.util.ArrayList;


public class BookFragment extends Fragment {

    private static final String TAG = "   ";

    private RecyclerView rvBook;

    private ArrayList<Book> books = new ArrayList<>();

    public static final String THEME_KEY = "THEME_KEY";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_book, container, false);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        rvBook = getActivity().findViewById(R.id.rv_book);

        Theme theme = (Theme) getArguments().get(THEME_KEY);

        ArrayList<Book> bookArrayList = new ArrayList<>();

        Log.d("ghpdp", "onStart: " + bookArrayList.size());

        for (int i = 0; i < NoDb.BOOK_LIST.size(); i++) {

            if (NoDb.BOOK_LIST.get(i).getTheme().getThemeName().equals(theme.getThemeName())) {
                bookArrayList.add(NoDb.BOOK_LIST.get(i));

            }
        }

        BookAdapter bookAdapter = new BookAdapter(getContext(), bookArrayList);

        rvBook.setAdapter(bookAdapter);

    }

    //    public void updateBookAdapter() {
//
//        bookAdapter.notifyDataSetChanged();
//    }

}