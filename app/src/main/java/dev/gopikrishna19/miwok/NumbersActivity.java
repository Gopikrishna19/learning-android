package dev.gopikrishna19.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        ArrayList<String> words = new ArrayList<>(Arrays.asList("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"));

        LinearLayout numbersActivity = (LinearLayout) findViewById(R.id.activity_numbers);

        for (String word : words) {

            TextView item = new TextView(this);
            item.setText(word);
            numbersActivity.addView(item);
        }
    }
}
