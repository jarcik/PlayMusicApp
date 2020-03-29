package com.example.playmusic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

/**
 * Activity for song list
 */
public class SongsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list);

        //Creating a list of the songs
        ArrayList<Song> songs = new ArrayList<Song>();
        //adding new songs
        AddNewSongs(songs);
        //set and adapter
        SetAdapter(songs);
    }

    /**
     * method for creating a list of the songs
     * @param list initialized list for songs
     */
    private void AddNewSongs(ArrayList<Song> list) {
        list.add(new Song("Sharp Edges", "Linkin Park", "One More Light"));
        list.add(new Song("Me", "Taylor Swift", "ME!"));
        list.add(new Song("Wake me up before you go", "Wham!", "Now That’s What I Call Music 3"));
        list.add(new Song("Take me back to London", "Ed Sheeran", "No.6 Collaborations Project"));
        list.add(new Song("I don't care", "Ed Sheeran, Justin Bieber", "I Don't Care"));
        list.add(new Song("Señorita", "Camila Cabello, Shawn Mendes", "Señorita"));
        list.add(new Song("stitches", "Shawn Mendes", "Handwritten"));
        list.add(new Song("Sugar", "Maroon 5", "V"));
        list.add(new Song("Set Me on Fire", "Bella Farraro", "Set Me on Fire"));
        list.add(new Song("I wanna dance with somebody", "Whitney", "Whitney"));
        list.add(new Song("Cross me", "Ed Sheeran", "No.6 Collaborations Project"));
        list.add(new Song("Rolling in the Deep", "Adele", "Rolling in the Deep"));
        list.add(new Song("In The End", "Linkin Park", "Reanimation "));
        list.add(new Song("One More Light", "Linkin Park", "One More Light"));
        list.add(new Song("Sorry for now", "Linkin Park", "One More Light"));
        list.add(new Song("Broken & Beautiful", "Kelly Clarkson", "Kelly Clarkson"));
        list.add(new Song("Heartbeat", "Kelly Clarkson", "Heartbeat Song"));
        list.add(new Song("Reputation", "Joe Robinson", "Reputation"));
        list.add(new Song("Skyline", "Joe Robinson", "Let Me Introduce You"));
        list.add(new Song("Adelaide", "Joe Robinson", "Let Me Introduce You"));
        list.add(new Song("Carry Me Away", "John Meyer", "Carry Me Away"));
    }

    /**
     * Set adapter to an listview in xml
     * @param songs
     */
    private void SetAdapter(final ArrayList<Song> songs) {
        //creating and adapter with the source of data as a songs arraylist
        SongAdapter songAdapter = new SongAdapter(this, songs);
        //listview object in xml
        ListView listView = findViewById(R.id.list);

        //set onitemclick for listview
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent nowPlayingIntent = new Intent(getBaseContext(), NowPlaying.class);
                nowPlayingIntent.putExtra("song", songs.get(position));
                startActivity(nowPlayingIntent);
            }
        });

        //set adapter to an listview
        listView.setAdapter(songAdapter);
    }

}
