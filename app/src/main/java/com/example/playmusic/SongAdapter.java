package com.example.playmusic;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

/**
 * ArrayAdapter for a Song class
 */
public class SongAdapter extends ArrayAdapter<Song> {

    //constructor
    public SongAdapter(@NonNull Context context, ArrayList<Song> songs) {
        super(context, 0, songs);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.song_item, parent, false);
        }

        //song located at position
        Song currentSong = getItem(position);

        //song name textview
        TextView songNameTV = listItemView.findViewById(R.id.songName);
        //set text to song name textview
        songNameTV.setText(currentSong.getName());

        //song artist textview
        TextView songArtistTV = listItemView.findViewById(R.id.artistName);
        //set text to song artist textview
        songArtistTV.setText(currentSong.getArtist());

        //song album textview
        TextView songAlbumTV = listItemView.findViewById(R.id.albumName);
        //set text to album name textview
        songAlbumTV.setText(currentSong.getAlbum());

        return listItemView;
    }
}
