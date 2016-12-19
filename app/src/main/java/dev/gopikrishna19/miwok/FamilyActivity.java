package dev.gopikrishna19.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

import dev.gopikrishna19.miwok.listeners.WordClickListener;
import dev.gopikrishna19.miwok.types.Word;
import dev.gopikrishna19.miwok.types.WordAdapter;

public class FamilyActivity extends AppCompatActivity {
    private WordClickListener wordClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_words);

        final ArrayList<Word> words = new ArrayList<>(
                Arrays.asList(
                        new Word("father", "әpә", R.raw.family_father, R.drawable.family_father),
                        new Word("mother", "әṭa", R.raw.family_mother, R.drawable.family_mother),
                        new Word("son", "angsi", R.raw.family_son, R.drawable.family_son),
                        new Word("daughter", "tune", R.raw.family_daughter, R.drawable.family_daughter),
                        new Word("older brother", "taachi", R.raw.family_older_brother, R.drawable.family_older_brother),
                        new Word("younger brother", "chalitti", R.raw.family_younger_brother, R.drawable.family_younger_brother),
                        new Word("older sister", "teṭe", R.raw.family_older_sister, R.drawable.family_older_sister),
                        new Word("younger sister", "kolliti", R.raw.family_younger_sister, R.drawable.family_younger_sister),
                        new Word("grandmother", "ama", R.raw.family_grandmother, R.drawable.family_grandmother),
                        new Word("grandfather", "paapa", R.raw.family_grandfather, R.drawable.family_grandfather)
                )
        );

        WordAdapter wordsAdapter = new WordAdapter(this, words, R.color.categoryFamily);

        ListView familyActivity = (ListView) findViewById(R.id.list_words);

        wordClickListener = new WordClickListener(this, words);

        familyActivity.setAdapter(wordsAdapter);
        familyActivity.setOnItemClickListener(wordClickListener);
    }

    @Override
    protected void onStop() {

        super.onStop();
        wordClickListener.releaseMediaPlayer();
    }
}
