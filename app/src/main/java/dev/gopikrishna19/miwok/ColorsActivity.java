package dev.gopikrishna19.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

import dev.gopikrishna19.miwok.types.Word;
import dev.gopikrishna19.miwok.types.WordAdapter;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_words);

        ArrayList<Word> words = new ArrayList<>(
                Arrays.asList(
                        new Word("red", "weṭeṭṭi"),
                        new Word("green", "chokokki"),
                        new Word("brown", "ṭakaakki"),
                        new Word("gray", "ṭopoppi"),
                        new Word("black", "kululli"),
                        new Word("white", "kelelli"),
                        new Word("dusty yellow", "ṭopiisә"),
                        new Word("mustard yellow", "chiwiiṭә")
                )
        );

        WordAdapter wordsAdapter = new WordAdapter(this, words);

        ListView numbersActivity = (ListView) findViewById(R.id.list_words);

        numbersActivity.setAdapter(wordsAdapter);
    }
}
