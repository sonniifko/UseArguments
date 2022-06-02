package com.example.useargumentsessay.adapter;

import static com.example.useargumentsessay.nodb.NoDb.BOOK_LIST;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.useargumentsessay.Fragment.ArgumentFragment;
import com.example.useargumentsessay.Fragment.BookFragment;
import com.example.useargumentsessay.R;
import com.example.useargumentsessay.domain.Book;
import com.example.useargumentsessay.domain.Theme;
import com.example.useargumentsessay.nodb.NoDb;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.MyHolderBook>{

    private Context context1;

    private LayoutInflater inflater;

    private List<Book> bookList;

    public BookAdapter(Context context, List<Book> bookList) {
        this.context1 = context;
        this.inflater = LayoutInflater.from(context);
        this.bookList = bookList;
    }

    public static final String THEME_KEY = "THEME_KEY";

    public class MyHolderBook extends RecyclerView.ViewHolder {

        TextView tvBook;

        public MyHolderBook(@NonNull View itemView) {
            super(itemView);

            tvBook = itemView.findViewById(R.id.tv_book_name1);

        }
    }

    @NonNull
    @Override
    public MyHolderBook onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.book_item, parent, false);

        return new MyHolderBook(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolderBook holder, int position) {

        Book book = bookList.get(position);

        holder.tvBook.setText(book.getName());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ArgumentFragment argumentFragment = new ArgumentFragment();

                Bundle bundle = new Bundle();
                bundle.putSerializable(THEME_KEY, book);

                argumentFragment.setArguments(bundle);

                ((AppCompatActivity)view.getContext()).getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.book_fr, argumentFragment)
                        .commit();
            }
        });

    }

    @Override
    public int getItemCount() {

        return bookList.size();
    }
}
