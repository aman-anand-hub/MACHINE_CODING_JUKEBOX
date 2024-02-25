package com.example.demo.commands;

import java.util.List;
import com.example.demo.entities.Playlist;
import com.example.demo.repositories.PlaylistRepository;
import com.example.demo.services.PlayerService;
import com.example.demo.services.PlaylistService;

public class DeleteSongFromPlaylistCommand implements ICommand{
    private final PlaylistService playlistService; 

    public DeleteSongFromPlaylistCommand(PlaylistService playlistService)
    { 
        this.playlistService = playlistService;
    }

    @Override
    public void invoke(List<String> tokens) {
        String name= tokens.get(1);
        Long songID= Long.parseLong(tokens.get(2));
        String output= playlistService.deleteSongFromPlaylist(name, songID);
        System.out.println(output);
    }

    
}
