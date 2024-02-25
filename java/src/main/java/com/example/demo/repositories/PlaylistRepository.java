package com.example.demo.repositories;

import com.example.demo.entities.Song;
import com.example.demo.entities.Playlist;
import com.example.demo.entities.Greeting;
import com.example.demo.repositories.SongRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlaylistRepository implements IPlaylistRepository{
    private Map<Long,Playlist> playlistMap;
    Long autoIncrement= 1L;
    private ISongRepository songRepository;

    public PlaylistRepository(ISongRepository songRepository)
    {
        playlistMap= new HashMap<Long,Playlist>();
        this.songRepository = songRepository;
    }

    @Override
    public Playlist save(String name, List<Long> songs) {
        List<Song> songsList= new ArrayList<>();
        for(Long id: songs)
        {
            songsList.add(songRepository.findById(id));
        }
        Playlist createdPlaylist= new Playlist(autoIncrement,name, songsList);
        playlistMap.put(autoIncrement, createdPlaylist);
        autoIncrement++;
        return createdPlaylist;
    }

    @Override
    public Playlist findById(Long id) {
        return playlistMap.get(id);
    }

    @Override
    public Playlist findByName(String name) {
        for (Playlist playlist : playlistMap.values()) {
            if (playlist.getName().equals(name)) {
                return playlist;
            }
        }
        return null; // Playlist with the specified name not found.
    }

    @Override
    public List<Song> allSongs(String name)
    {
        Playlist p= findByName(name);
        return p.getSongs();
    }

    @Override
    public void deletedPlaylist(Playlist p)
    {
        Long id= p.getId();
        playlistMap.remove(id);
    }
}
