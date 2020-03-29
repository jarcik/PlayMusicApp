package com.example.playmusic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

/**
 * Activity for now playing songs
 */
public class NowPlaying extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.now_playing);
        //icon back
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //get played song
        Song song = getIntent().getParcelableExtra("song");

        //set name of the song
        TextView nowSong = findViewById(R.id.nowSong);
        nowSong.setText(song.getName());

        //set artist of the song
        TextView nowArtist = findViewById(R.id.nowArtist);
        nowArtist.setText(song.getArtist());

        //set album of the song
        TextView nowAlbum = findViewById(R.id.nowAlbum);
        nowAlbum.setText(song.getAlbum());
    }
}
