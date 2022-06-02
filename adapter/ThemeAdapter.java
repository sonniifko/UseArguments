package com.example.useargumentsessay.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.useargumentsessay.Fragment.BookFragment;
import com.example.useargumentsessay.R;
import com.example.useargumentsessay.domain.Book;
import com.example.useargumentsessay.domain.Theme;
import com.example.useargumentsessay.nodb.NoDb;

import java.util.List;

public class ThemeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final Context context;

    private final LayoutInflater inflater;

    private final List<Theme> themeList;

    public static final String THEME_KEY = "THEME_KEY";

    public ThemeAdapter(Context context, List<Theme> themeList) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.themeList = themeList;
    }

    private class MyHolder extends RecyclerView.ViewHolder {

        private TextView tvTheme;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            tvTheme = itemView.findViewById(R.id.tv_theme_name1);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.theme_item, parent, false);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Theme theme = NoDb.THEME_LIST.get(position);

        ((MyHolder)holder).tvTheme.setText(theme.getThemeName());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                BookFragment bookFragment = new BookFragment();

                Bundle bundle = new Bundle();
                bundle.putSerializable(THEME_KEY, theme);

                bookFragment.setArguments(bundle);

                ((AppCompatActivity)context).getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fl_main, bookFragment)
                        .commit();
            }
        });

    }

    @Override
    public int getItemCount() {

        return NoDb.THEME_LIST.size();
    }
}
