package dev.gopikrishna19.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

import dev.gopikrishna19.miwok.types.Word;
import dev.gopikrishna19.miwok.types.WordAdapter;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_words);

        ArrayList<Word> words = new ArrayList<>(
                Arrays.asList(
                        new Word("one", "lutti"),
                        new Word("two", "otiiko"),
                        new Word("three", "tolookosu"),
                        new Word("four", "oyyisa"),
                        new Word("five", "massoka"),
                        new Word("six", "temmokka"),
                        new Word("seven", "kenekaku"),
                        new Word("eight", "kawinta"),
                        new Word("nine", "wo'e"),
                        new Word("ten", "na'aacha")
                )
        );

        WordAdapter wordsAdapter = new WordAdapter(this, words);

        ListView numbersActivity = (ListView) findViewById(R.id.list_words);

        numbersActivity.setAdapter(wordsAdapter);
    }
}
