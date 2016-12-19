package dev.gopikrishna19.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import dev.gopikrishna19.miwok.listeners.CategoryClickListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setClickListeners();
    }

    private void setClickListeners() {

        CategoryClickListener categoryClickListener = new CategoryClickListener();

        findViewById(R.id.colors).setOnClickListener(categoryClickListener);
        findViewById(R.id.family).setOnClickListener(categoryClickListener);
        findViewById(R.id.numbers).setOnClickListener(categoryClickListener);
        findViewById(R.id.phrases).setOnClickListener(categoryClickListener);
    }
}
