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
                        new Word("one", "lutti", R.drawable.number_one),
                        new Word("two", "otiiko", R.drawable.number_two),
                        new Word("three", "tolookosu", R.drawable.number_three),
                        new Word("four", "oyyisa", R.drawable.number_four),
                        new Word("five", "massoka", R.drawable.number_five),
                        new Word("six", "temmokka", R.drawable.number_six),
                        new Word("seven", "kenekaku", R.drawable.number_seven),
                        new Word("eight", "kawinta", R.drawable.number_eight),
                        new Word("nine", "wo'e", R.drawable.number_nine),
                        new Word("ten", "na'aacha", R.drawable.number_ten)
                )
        );

        WordAdapter wordsAdapter = new WordAdapter(this, words, R.color.categoryNumbers);

        ListView numbersActivity = (ListView) findViewById(R.id.list_words);

        numbersActivity.setAdapter(wordsAdapter);
    }
}
