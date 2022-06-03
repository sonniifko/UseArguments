package com.example.useargumentsessay;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.useargumentsessay.fragment.SettingBook;
import com.example.useargumentsessay.fragment.SettingsFragment;
import com.example.useargumentsessay.adapter.ThemeAdapter;
import com.example.useargumentsessay.domain.Theme;
import com.example.useargumentsessay.nodb.NoDb;
import com.example.useargumentsessay.rest.UseApiVolley;

import java.util.List;

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

//        search.addTextChangedListener(new TextWatcher() {
//
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//
//                if(editable.toString().isEmpty()) {
//
//                    rvTheme.setAdapter(new ThemeAdapter(getApplicationContext(), themeList));
//                    themeAdapter.notifyDataSetChanged();
//                }
//
//            }
//        });

        btnSettings.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                //тут закоменчено добавление аргументов

//                SettingsFragment settingsFragment = new SettingsFragment();
//
//                getSupportFragmentManager()
//                        .beginTransaction()
//                        .add(R.id.fl_main, settingsFragment)
//                        .addToBackStack(null)
//                        .commit();

                SettingBook settingBook = new SettingBook();

                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fl_main, settingBook)
                        .addToBackStack(null)
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