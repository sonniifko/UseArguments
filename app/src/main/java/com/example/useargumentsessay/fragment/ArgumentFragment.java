package com.example.useargumentsessay.fragment;

import static com.example.useargumentsessay.adapter.BookAdapter.THEME_KEY;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.useargumentsessay.R;
import com.example.useargumentsessay.adapter.ArgumentAdapter;
import com.example.useargumentsessay.domain.Argument;
import com.example.useargumentsessay.domain.Book;
import com.example.useargumentsessay.nodb.NoDb;

import java.util.ArrayList;

public class ArgumentFragment extends Fragment {

        private static final String TAG = "   ";

        private RecyclerView rvArgument;

        private ArrayList<Argument> arguments = new ArrayList<>();

        public static final String BOOK_KEY = "BOOK_KEY";

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {

            View view = inflater.inflate(R.layout.fragment_argument, container, false);



            return view;
        }

        @Override
        public void onStart() {
            super.onStart();

            rvArgument = getActivity().findViewById(R.id.rv_argument);

            Book book = (Book) getArguments().getSerializable(THEME_KEY);

            Log.d("fghjk", "onStart: " + book);



//            for (int i = 0; i < NoDb.ARGUMENT_LIST.size(); i++) {
//
//                if (NoDb.ARGUMENT_LIST.get(i).getBook().getName().equals(book.getName())) {
//                    arguments.add(NoDb.ARGUMENT_LIST.get(i));
//
//                }
//            }



            ArgumentAdapter argumentAdapter = new ArgumentAdapter(getContext(), book.getArgument());

            rvArgument.setAdapter(argumentAdapter);

            Log.i("tvArg1",NoDb.ARGUMENT_LIST.toString());

        }
}