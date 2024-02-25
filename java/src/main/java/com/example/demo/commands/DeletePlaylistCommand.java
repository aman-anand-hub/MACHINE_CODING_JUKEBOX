package com.example.demo.commands;

import java.util.List;
import com.example.demo.entities.Playlist;
import com.example.demo.repositories.PlaylistRepository;
import com.example.demo.services.PlayerService;
import com.example.demo.services.PlaylistService;

public class DeletePlaylistCommand implements ICommand {
    private final PlaylistService playlistService; 

    public DeletePlaylistCommand(PlaylistService playlistService)
    { 
        this.playlistService = playlistService;
    }

    @Override
    public void invoke(List<String> tokens) {
        String name= tokens.get(1);
        String output= playlistService.deletePlaylist(name);
        System.out.println(output);
    }
    
}
