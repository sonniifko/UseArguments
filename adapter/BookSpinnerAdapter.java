package com.example.useargumentsessay.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.useargumentsessay.R;
import com.example.useargumentsessay.domain.Book;
import com.example.useargumentsessay.nodb.NoDb;

import java.util.List;

public class BookSpinnerAdapter extends ArrayAdapter<Book> {

    public BookSpinnerAdapter(
            @NonNull Context context,
            @NonNull List<Book> objects
    ) {

        super(context, R.layout.spinner_item, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {

            convertView = LayoutInflater.from((getContext()))
                    .inflate(R.layout.spinner_item, null);
        }

        ((TextView)convertView.findViewById(R.id.tv_spinner_item))
                .setText(NoDb.BOOK_LIST.get(position).getName());

        return convertView;
    }
}
