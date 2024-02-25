package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import com.example.demo.entities.Song;
import com.example.demo.repositories.ISongRepository;
import com.example.demo.repositories.SongRepository;
import com.example.demo.repositories.IPlaylistRepository;
import com.example.demo.repositories.IGreetingRepository;

public class SongService {
    private ISongRepository songRepository;
    private IPlaylistRepository playlistRepository;

    public SongService(ISongRepository songRepository, IPlaylistRepository playlistRepository) {
        this.songRepository = songRepository;
        this.playlistRepository = playlistRepository;
    }

    // ADD_SONG service
    // i/p: ADD_SONG Song_1 Artist_1 Album_1 Genre_1
    // o/p: Song [id=1]
    public String addSong(String name, String artist, String album, String genre)
    {
        songRepository.save(name, artist, album, genre);
        Song s= songRepository.findByName(name);
        return s.toString();
    }

    // LIST_SONGS service
    // i/p: LIST_SONGS (no input parameters)
    // o/p: [Song [id=1], Song [id=2], Song [id=3], Song [id=4], Song [id=5], Song [id=6], Song [id=7], Song [id=8], Song [id=9], Song [id=10]]
    public List<String> list_Songs()
    {
        // List<Song> allSongs=  songRepository.listAll();
        // List<String> allSongsList= new ArrayList<>();
        // for(Song song : allSongs)
        // {
        //     allSongsList.add(song.toString());
        // }
        // String result= "";
        // for(String s: allSongsList)
        // {
        //     result+= s + " ";
        // }
        // return result;

        List<Song> allSongs=  songRepository.listAll();
        List<String> allSongsList= new ArrayList<>();
        for(Song song : allSongs)
        {
            allSongsList.add(song.toString());
        }

        return allSongsList;
    }
}