package com.example.useargumentsessay.fragment;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.useargumentsessay.MainActivity;
import com.example.useargumentsessay.R;

public class AddSmth extends Fragment {

    private AppCompatButton btn_fr_add_book;
    private AppCompatButton btn_fr_add_arg;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_smth, container, false);

        btn_fr_add_book = view.findViewById(R.id.btn_fr_add_book);
        btn_fr_add_arg = view.findViewById(R.id.btn_fr_add_arg);

        btn_fr_add_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SettingBook settingBook = new SettingBook();

                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.add_smth, settingBook)
                        .commit();
            }
        });

        btn_fr_add_arg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SettingsFragment settingsFragment = new SettingsFragment();

                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.add_smth, settingsFragment)
                        .commit();
            }
        });

        return view;
    }
}