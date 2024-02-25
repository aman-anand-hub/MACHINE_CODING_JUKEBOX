package com.example.demo.commands;

import java.util.List;
import com.example.demo.entities.Playlist;
import com.example.demo.repositories.PlaylistRepository;
import com.example.demo.services.PlayerService;
import com.example.demo.services.PlaylistService;

public class AddSongToPlaylistCommand implements ICommand {

    private final PlaylistService playlistService; 

    public AddSongToPlaylistCommand(PlaylistService playlistService)
    { 
        this.playlistService = playlistService;
    }

    @Override
    public void invoke(List<String> tokens) {
        String name= tokens.get(1);
        Long songID= Long.parseLong(tokens.get(2));
        String output= playlistService.addSongToPlaylist(name, songID);
        System.out.println(output);
    }
    
}
