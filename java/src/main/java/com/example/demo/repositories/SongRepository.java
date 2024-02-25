package com.example.demo.repositories;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import com.example.demo.entities.Song;
import com.example.demo.entities.Playlist;
import com.example.demo.entities.Greeting;

public class SongRepository implements ISongRepository {
    private List<Song> songsPool;
    private Long autoIncrement = 1L;

    public SongRepository() {
        songsPool = new ArrayList<>();
    }

    @Override
    public Song save(String name, String artist, String album, String genre) {
        Song song = new Song(autoIncrement, name, artist, album, genre);
        if (songsPool.add(song)) {
            autoIncrement++;
            return song;
        }
        return null; 
    }

    @Override
    public Song findById(Long id) {

        for (Song song : songsPool) {
            if (song.getId().equals(id)) {
                return song;
            }
        }
        return null; 
    }

    @Override
    public Song findByName(String name) {
        for (Song song : songsPool) {
            if (song.getName().equals(name)) {
                return song;
            }
        }
        return null; 
    }

    @Override
    public List<Song> listAll()
    {
        return new ArrayList<>(songsPool);
    }
}
