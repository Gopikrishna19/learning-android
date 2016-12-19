package dev.gopikrishna19.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

import dev.gopikrishna19.miwok.listeners.WordClickListener;
import dev.gopikrishna19.miwok.types.Word;
import dev.gopikrishna19.miwok.types.WordAdapter;

public class PhrasesActivity extends AppCompatActivity {
    private WordClickListener wordClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_words);

        final ArrayList<Word> words = new ArrayList<>(
                Arrays.asList(
                        new Word("Where are you going?", "minto wuksus", R.raw.phrase_where_are_you_going),
                        new Word("What is your name?", "tinnә oyaase 'nә", R.raw.phrase_what_is_your_name),
                        new Word("My name is...", "oyaaset...", R.raw.phrase_my_name_is),
                        new Word("How are you feeling?", "michәksәs?", R.raw.phrase_how_are_you_feeling),
                        new Word("I’m feeling good.", "kuchi achit", R.raw.phrase_im_feeling_good),
                        new Word("Are you coming?", "әәnәs 'aa?", R.raw.phrase_are_you_coming),
                        new Word("Yes, I’m coming.", "hәә’әәnәm", R.raw.phrase_yes_im_coming),
                        new Word("I’m coming.", "әәnәm", R.raw.phrase_im_coming),
                        new Word("Let’s go.", "yoowutis", R.raw.phrase_lets_go),
                        new Word("Come here.", "әnni 'nem", R.raw.phrase_come_here)
                )
        );

        WordAdapter wordsAdapter = new WordAdapter(this, words, R.color.categoryPhrases);

        ListView phrasesActivity = (ListView) findViewById(R.id.list_words);

        wordClickListener = new WordClickListener(words);

        phrasesActivity.setAdapter(wordsAdapter);
        phrasesActivity.setOnItemClickListener(wordClickListener);
    }

    @Override
    protected void onStop() {

        super.onStop();
        wordClickListener.releaseMediaPlayer();
    }
}
