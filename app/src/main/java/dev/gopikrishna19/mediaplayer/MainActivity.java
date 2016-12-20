package dev.gopikrishna19.mediaplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this, R.raw.ethir_neechal_adi);
    }

    public void play(View view) {

        mediaPlayer.start();
    }

    public void pause(View view) {

        mediaPlayer.pause();
    }
}
