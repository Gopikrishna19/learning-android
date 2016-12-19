package dev.gopikrishna19.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

import dev.gopikrishna19.miwok.listeners.WordClickListener;
import dev.gopikrishna19.miwok.types.Word;
import dev.gopikrishna19.miwok.types.WordAdapter;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_words);

        final ArrayList<Word> words = new ArrayList<>(
                Arrays.asList(
                        new Word("red", "weṭeṭṭi", R.raw.color_red, R.drawable.color_red),
                        new Word("green", "chokokki", R.raw.color_green, R.drawable.color_green),
                        new Word("brown", "ṭakaakki", R.raw.color_brown, R.drawable.color_brown),
                        new Word("gray", "ṭopoppi", R.raw.color_gray, R.drawable.color_gray),
                        new Word("black", "kululli", R.raw.color_black, R.drawable.color_black),
                        new Word("white", "kelelli", R.raw.color_white, R.drawable.color_white),
                        new Word("dusty yellow", "ṭopiisә", R.raw.color_dusty_yellow, R.drawable.color_dusty_yellow),
                        new Word("mustard yellow", "chiwiiṭә", R.raw.color_mustard_yellow, R.drawable.color_mustard_yellow)
                )
        );

        WordAdapter wordsAdapter = new WordAdapter(this, words, R.color.categoryColors);

        ListView colorsActivity = (ListView) findViewById(R.id.list_words);

        colorsActivity.setAdapter(wordsAdapter);
        colorsActivity.setOnItemClickListener(new WordClickListener(words));
    }
}
