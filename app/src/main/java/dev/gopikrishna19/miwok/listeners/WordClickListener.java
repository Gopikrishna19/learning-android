package dev.gopikrishna19.miwok.listeners;

import android.media.MediaPlayer;
import android.view.View;
import android.widget.AdapterView;

import java.util.List;

import dev.gopikrishna19.miwok.types.Word;

public class WordClickListener implements AdapterView.OnItemClickListener {
    private List<Word> words;
    private MediaPlayer mediaPlayer;

    public WordClickListener(List<Word> words) {

        this.words = words;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

        releaseMediaPlayer();

        mediaPlayer = MediaPlayer.create(view.getContext(), words.get(position).getRawPronunciation());
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {

                releaseMediaPlayer();
            }
        });

        mediaPlayer.start();
    }

    private void releaseMediaPlayer() {

        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
