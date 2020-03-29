package com.example.playmusic;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Class for song
 */
public class Song implements Parcelable {

    //name of the song
    private String name;
    //artist of the song
    private String artist;
    //album where song appears
    private String album;

    //constructor
    public Song(String n, String ar, String al) {
        //assigning variables
        name = n;
        artist = ar;
        album = al;
    }


    //parcel part
    public Song(Parcel in) {
        String[] data = new String[3];
        in.readStringArray(data);
        name = data[0];
        artist = data[1];
        album = data[2];
    }

    //getters
    public String getName() {
        return name;
    }
    public String getArtist() {
        return artist;
    }
    public String getAlbum() {
        return album;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[]{name,artist,album});
    }

    public static final Parcelable.Creator<Song> CREATOR= new Parcelable.Creator<Song>() {

        @Override
        public Song createFromParcel(Parcel source) {
            return new Song(source);  //using parcelable constructor
        }

        @Override
        public Song[] newArray(int size) {
            return new Song[size];
        }
    };
}
