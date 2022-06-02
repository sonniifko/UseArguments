package com.example.useargumentsessay;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.useargumentsessay.adapter.ThemeAdapter;
import com.example.useargumentsessay.domain.Book;
import com.example.useargumentsessay.domain.Theme;
import com.example.useargumentsessay.nodb.NoDb;
import com.example.useargumentsessay.rest.UseApiVolley;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.security.ProviderInstaller;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.net.ssl.SSLContext;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "   ";

    private RecyclerView rvTheme;

    private ThemeAdapter themeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new  UseApiVolley(this).fillTheme();

        rvTheme = findViewById(R.id.rv_theme);

        themeAdapter = new ThemeAdapter(MainActivity.this, NoDb.THEME_LIST);

        Log.e("is null", "THEME_LIST" + NoDb.THEME_LIST.size());

        rvTheme.setAdapter(themeAdapter);


    }

    public void updateThemeAdapter() {

        themeAdapter.notifyDataSetChanged();
    }
}