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
                        new Word("red", "weṭeṭṭi", R.drawable.color_red),
                        new Word("green", "chokokki", R.drawable.color_green),
                        new Word("brown", "ṭakaakki", R.drawable.color_brown),
                        new Word("gray", "ṭopoppi", R.drawable.color_gray),
                        new Word("black", "kululli", R.drawable.color_black),
                        new Word("white", "kelelli", R.drawable.color_white),
                        new Word("dusty yellow", "ṭopiisә", R.drawable.color_dusty_yellow),
                        new Word("mustard yellow", "chiwiiṭә", R.drawable.color_mustard_yellow)
                )
        );

        WordAdapter wordsAdapter = new WordAdapter(this, words);

        ListView numbersActivity = (ListView) findViewById(R.id.list_words);

        numbersActivity.setAdapter(wordsAdapter);
    }
}
