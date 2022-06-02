package com.example.useargumentsessay;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.useargumentsessay.Fragment.SettingsFragment;
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
import java.util.List;

import javax.net.ssl.SSLContext;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "   ";

    private RecyclerView rvTheme;

    private ThemeAdapter themeAdapter;

    private AppCompatButton btnSettings;

    private List<Theme> themeList;

    private EditText search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSettings = findViewById(R.id.btn_settings);

        search = findViewById(R.id.search);

        search.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                if(editable.toString().isEmpty()) {

                    rvTheme.setAdapter(new ThemeAdapter(getApplicationContext(), themeList));
                    themeAdapter.notifyDataSetChanged();
                }

            }
        });

        btnSettings.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                SettingsFragment settingsFragment = new SettingsFragment();

                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fl_main, settingsFragment)
                        .commit();
            }
        });

        new  UseApiVolley(this).fillTheme();

        new UseApiVolley(this).fillBook();

        rvTheme = findViewById(R.id.rv_theme);

        themeAdapter = new ThemeAdapter(MainActivity.this, NoDb.THEME_LIST);

        Log.e("is null", "THEME_LIST" + NoDb.THEME_LIST.size());

        rvTheme.setAdapter(themeAdapter);

        rvTheme.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));


    }

    public void updateThemeAdapter() {

        themeAdapter.notifyDataSetChanged();
    }
}