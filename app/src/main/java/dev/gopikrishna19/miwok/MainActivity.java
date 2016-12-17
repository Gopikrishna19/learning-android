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

        ClickListener clickListener = new ClickListener();

        findViewById(R.id.colors).setOnClickListener(clickListener);
        findViewById(R.id.family).setOnClickListener(clickListener);
        findViewById(R.id.numbers).setOnClickListener(clickListener);
        findViewById(R.id.phrases).setOnClickListener(clickListener);
    }
}
