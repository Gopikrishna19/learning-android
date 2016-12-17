package dev.gopikrishna19.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        ArrayList<String> words = new ArrayList<>(Arrays.asList("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"));
        ArrayAdapter<String> wordsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, words);

        ListView numbersActivity = (ListView) findViewById(R.id.activity_numbers);

        numbersActivity.setAdapter(wordsAdapter);
    }
}
