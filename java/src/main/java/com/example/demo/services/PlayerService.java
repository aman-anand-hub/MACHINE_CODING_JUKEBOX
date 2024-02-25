package com.example.demo.services;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Deque;
import com.example.demo.entities.Playlist;
import com.example.demo.entities.Song;
import com.example.demo.repositories.ISongRepository;
import com.example.demo.repositories.SongRepository;
import com.example.demo.repositories.IPlaylistRepository;
import com.example.demo.repositories.IGreetingRepository;

public class PlayerService {
    private final ISongRepository songRepository;
    private final IPlaylistRepository playlistRepository;
    private PlayerState currentState;
    private Queue<Song> activePlaylist;

    public PlayerService(ISongRepository songRepository, IPlaylistRepository playlistRepository)
    {
        this.songRepository= songRepository;
        this.playlistRepository= playlistRepository;
        this.currentState= PlayerState.IDLE;
        this.activePlaylist= new LinkedList<>();
    }

    public PlayerState getState()
    {
        return currentState;
    }

    // LOAD_PLAYLIST <playlist-name>
    // i/p: LOAD_PLAYLIST PLAYLIST_2
    // o/p: : Playlist PLAYLIST_2 is loaded!
    public String loadPlaylist(String playlistName)
    {
        activePlaylist.clear();
        List<Song> playlistSongs= playlistRepository.allSongs(playlistName);
        for(Song song: playlistSongs)
        {
            activePlaylist.add(song);
        }
        return "Playlist " + playlistName + " is loaded!";
    }

    // PLAY_SONG 
    // Eg: PLAY_SONG
    // Output :Song [id=2] is playing!
    public String playSong()
    {
        // if state is ideal then change it to playing 
        // if state is playing then change it to paused
        // if state is paused then change it to playing
        
        if (currentState == PlayerState.IDLE) {
            currentState = PlayerState.PLAYING;
        } else if (currentState == PlayerState.PLAYING) {
            currentState = PlayerState.PAUSED;
        } else if (currentState == PlayerState.PAUSED) {
            currentState = PlayerState.PLAYING;
        }
        Song currentSong = activePlaylist.peek();
        String lastWord= (currentState == PlayerState.PAUSED)? "paused!":"playing!";

        return  currentSong.toString() + " is " + lastWord;
    }

    // NEXT_SONG
    // i/p: NEXT_SONG
    // o/p: Song [id=4] is playing!
    public String nextSong()
    {
        // pop the top element of the queue and put it back to the last place in the queue
        // if state is ideal then change it to ideal
        // if state is playing then change it to playing
        // if state is paused then change it to playing

            Song nextSong = activePlaylist.poll();
            activePlaylist.offer(nextSong);

            if (currentState == PlayerState.IDLE) {
                currentState = PlayerState.IDLE;
            } else if (currentState == PlayerState.PLAYING || currentState == PlayerState.PAUSED) {
                currentState = PlayerState.PLAYING;
            }
            Song currentSong = activePlaylist.peek();
            return currentSong.toString() + " is playing!";
    }

    // PREVIOUS_SONG
    // i/p: PREVIOUS_SONG
    // o/p: Song [id=2] is playing!
    public String previousSong()
    {
        // pop the last element of the queue and insert it back to the first place in the queue
        // if state is ideal then change it to ideal
        // if state is playing then change it to playing
        // if state is paused then change it to playing

        Deque<Song> dequePlaylist = (Deque<Song>) activePlaylist;
        Song lastSong = dequePlaylist.pollLast();
        dequePlaylist.offerFirst(lastSong);

        if (currentState == PlayerState.IDLE) {
            currentState = PlayerState.IDLE;
        } else if (currentState == PlayerState.PLAYING || currentState == PlayerState.PAUSED) {
            currentState = PlayerState.PLAYING;
        }
        Song currentSong= activePlaylist.peek();
        return currentSong.toString() + " is playing!";
    }

    // STOP_SONG
    // i/p: STOP_SONG
    // o/p: Song [id=2] is stopped
    public String stopSong()
    {
        // if state is ideal then change it to ideal 
        // if state is playing then change it to ideal
        // if state is paused then change it to ideal

        currentState = PlayerState.IDLE;
        Song currentSong = activePlaylist.peek();
        return currentSong.toString() + " is stopped!";
    }
}
