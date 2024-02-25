package com.example.demo.repositories;

import java.util.List;
import com.example.demo.entities.Song;
import com.example.demo.entities.Playlist;
import com.example.demo.entities.Greeting;

public interface IPlaylistRepository {
    Playlist save(String name, List<Long>songs);
    Playlist findById(Long id);
    Playlist findByName(String name);
    List<Song> allSongs(String name);
    void deletedPlaylist(Playlist p);
}
