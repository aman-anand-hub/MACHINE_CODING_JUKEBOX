package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import com.example.demo.entities.Playlist;
import com.example.demo.entities.Song;
import com.example.demo.repositories.ISongRepository;
import com.example.demo.repositories.PlaylistRepository;
import com.example.demo.repositories.IPlaylistRepository;

public class PlaylistService {
    private IPlaylistRepository playlistRepository;
    private ISongRepository songRepository;

    public PlaylistService(IPlaylistRepository playlistRepository, ISongRepository songRepository) {
        this.playlistRepository = playlistRepository;
        this.songRepository = songRepository;
    }

    // CREATE_PLAYLIST service
    // i/p: CREATE_PLAYLIST PLAYLIST_1 2 4 6 8
    // o/p: Playlist [id=1]
    public String createPlaylist(String name, List<Long> songs)
    {
        Playlist pp= playlistRepository.save(name, songs);
        // Playlist justCreatedPlaylist= playlistRepository.findByName(name);
        return pp.toString();
    }

    // ADD_SONG_TO_PLAYLIST service
    // i/p: ADD_SONG_TO_PLAYLIST PLAYLIST_2 8
    // o/p: Playlist PLAYLIST_2 is revised with [Song [id=1], Song [id=3], Song [id=5], Song [id=7], Song [id=9], Song [id=8]]
    public String addSongToPlaylist(String name, Long id)
    {
        Playlist p= playlistRepository.findByName(name);
        Song toBeAdded= songRepository.findById(id);
        p.addSong(toBeAdded);
        List<Song> listSongs= p.getSongs();
        return "Playlist " + name + " is revised with " + listSongs.toString();
    }

    // DELETE_SONG_FROM_PLAYLIST service
    // i/p: DELETE_SONG_FROM_PLAYLIST PLAYLIST_2 9
    // o/p: Playlist PLAYLIST_2 is revised with [Song [id=1], Song [id=3], Song [id=5], Song [id=7], Song [id=8]]
    public String  deleteSongFromPlaylist(String playlistName, Long  songId)
    {
        Playlist p= playlistRepository.findByName(playlistName);
        Song song= songRepository.findById(songId);
        p.deleteSong(song);
        List<Song> newListSongs= new ArrayList<>();
        newListSongs= playlistRepository.allSongs(playlistName);
        return "Playlist " + playlistName + " is revised with " + newListSongs.toString();
    }

    // DELETE_PLAYLIST service
    // i/p: DELETE_PLAYLIST PLAYLIST_1
    // o/p: Playlist PLAYLIST_1 is deleted!
    public String deletePlaylist(String playlistName)
    {
        Playlist p= playlistRepository.findByName(playlistName);
        playlistRepository.deletedPlaylist(p);
        return "Playlist " + playlistName + " is deleted!";
    }   
}
