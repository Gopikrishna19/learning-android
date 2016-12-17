package dev.gopikrishna19.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import dev.gopikrishna19.miwok.listeners.ClickListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setClickListeners();
    }

    private void setClickListeners() {

        findViewById(R.id.colors).setOnClickListener(new ClickListener());
        findViewById(R.id.family).setOnClickListener(new ClickListener());
        findViewById(R.id.numbers).setOnClickListener(new ClickListener());
        findViewById(R.id.phrases).setOnClickListener(new ClickListener());
    }
}
