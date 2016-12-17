package dev.gopikrishna19.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

import dev.gopikrishna19.miwok.types.Word;
import dev.gopikrishna19.miwok.types.WordAdapter;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_words);

        ArrayList<Word> words = new ArrayList<>(
                Arrays.asList(
                        new Word("father", "әpә"),
                        new Word("mother", "әṭa"),
                        new Word("son", "angsi"),
                        new Word("daughter", "tune"),
                        new Word("older brother", "taachi"),
                        new Word("younger brother", "chalitti"),
                        new Word("older sister", "teṭe"),
                        new Word("younger sister", "kolliti"),
                        new Word("grandmother", "ama"),
                        new Word("grandfather", "paapa")
                )
        );

        WordAdapter wordsAdapter = new WordAdapter(this, words);

        ListView numbersActivity = (ListView) findViewById(R.id.list_words);

        numbersActivity.setAdapter(wordsAdapter);
    }
}
