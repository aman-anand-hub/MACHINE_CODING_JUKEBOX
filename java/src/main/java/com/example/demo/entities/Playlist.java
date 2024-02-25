package com.example.demo.entities;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private final Long id;
    private final String name;
    private List<Song> songs= new ArrayList<>();

    public Playlist(Long id, String name, List<Song> songs) {
        this.id = id;
        this.name = name;
        // this.songs = new ArrayList<>(songs);
        this.songs= songs;
    }

    public Playlist(String name, List<Song> songs) {
        this.id = null;
        this.name = name;
        // this.songs = new ArrayList<>(songs);
        this.songs= songs;
    }

    public Long getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public List<Song> getSongs()
    {
        return songs;
    }

    public void addSong(Song newSong) {
        songs.add(newSong);
    }

    public void deleteSong(Song removeSong) {
        songs.remove(removeSong);
    }

    @Override
    public String toString()
    {
        return "Playlist [id="+ id+"]";
    }
}