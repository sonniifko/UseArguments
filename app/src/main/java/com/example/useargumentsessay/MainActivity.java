package com.example.useargumentsessay;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.opengl.Visibility;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.useargumentsessay.fragment.AddSmth;
import com.example.useargumentsessay.fragment.SettingBook;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSettings = findViewById(R.id.btn_settings);

        btnSettings.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                AddSmth addSmth = new AddSmth();

                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fl_main, addSmth)
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

    public void setNewFragment(Fragment fragment) { //переклюявтель на другие фрагменты
        FragmentTransaction ft = MainActivity.this.getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fl_main, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }


}