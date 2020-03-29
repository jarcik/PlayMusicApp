package com.example.playmusic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //assigning onlicklistener to songs
        TextView songsTextView = findViewById(R.id.songs);
        songsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent songsIntent = new Intent(MainActivity.this, SongsActivity.class);
                startActivity(songsIntent);
            }
        });

        //assigning onlicklistener to now playing
        TextView nowTextView = findViewById(R.id.nowPlaying);
        nowTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nowIntent = new Intent(MainActivity.this, NowPlaying.class);
                nowIntent.putExtra("song", new Song("Sharp Edges", "Linkin Park", "One More Light"));
                startActivity(nowIntent);
            }
        });
    }
}
