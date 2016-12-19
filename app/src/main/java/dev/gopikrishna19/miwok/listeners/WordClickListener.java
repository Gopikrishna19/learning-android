package dev.gopikrishna19.miwok.listeners;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.AdapterView;

import java.util.List;

import dev.gopikrishna19.miwok.types.Word;

public class WordClickListener implements AdapterView.OnItemClickListener {
    private AudioManager audioManager;
    private List<Word> words;
    private MediaPlayer mediaPlayer;

    private AudioManager.OnAudioFocusChangeListener audioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int audioState) {

            switch (audioState) {
                case AudioManager.AUDIOFOCUS_GAIN:
                    mediaPlayer.start();
                    break;
                case AudioManager.AUDIOFOCUS_LOSS:
                    releaseMediaPlayer();
                    break;
                case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT:
                case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK:
                    mediaPlayer.pause();
                    mediaPlayer.seekTo(0);
                    break;
            }
        }
    };

    public WordClickListener(Context context, List<Word> words) {

        this.audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        this.words = words;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

        releaseMediaPlayer();

        int focus = audioManager.requestAudioFocus(
                audioFocusChangeListener,
                AudioManager.STREAM_MUSIC,
                AudioManager.AUDIOFOCUS_GAIN_TRANSIENT
        );

        if (focus == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
            mediaPlayer = MediaPlayer.create(view.getContext(), words.get(position).getRawPronunciation());
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {

                    releaseMediaPlayer();
                }
            });
            mediaPlayer.start();
        }
    }

    public void releaseMediaPlayer() {

        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
            audioManager.abandonAudioFocus(audioFocusChangeListener);
        }
    }
}
