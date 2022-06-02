package com.example.useargumentsessay.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.useargumentsessay.R;
import com.example.useargumentsessay.domain.Argument;
import com.example.useargumentsessay.domain.Book;
import com.example.useargumentsessay.nodb.NoDb;

import java.util.List;

public class ArgumentAdapter extends RecyclerView.Adapter<ArgumentAdapter.MyHolderArgument> {

    private Context context1;

    private LayoutInflater inflater;

    private List<Argument> argumentList;

    public ArgumentAdapter(Context context1, List<Argument> argumentList) {
        this.context1 = context1;
        this.inflater = LayoutInflater.from(context1);
        this.argumentList = argumentList;
    }

    public class MyHolderArgument extends RecyclerView.ViewHolder {

        TextView tvArgument;


        public MyHolderArgument(@NonNull View itemView) {
            super(itemView);

            tvArgument = itemView.findViewById(R.id.tv_argument_name);

        }
    }

    @NonNull
    @Override
    public ArgumentAdapter.MyHolderArgument onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.argument_item, parent, false);

        return new ArgumentAdapter.MyHolderArgument(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArgumentAdapter.MyHolderArgument holder, int position) {

        Argument argument = argumentList.get(position);

        holder.tvArgument.setText(argument.getContent());
    }

    @Override
    public int getItemCount() {

        return argumentList.size();
    }
}
