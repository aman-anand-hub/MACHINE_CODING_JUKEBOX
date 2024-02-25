package com.example.demo.commands;

import java.util.List;
import javax.swing.Icon;

import com.example.demo.entities.Playlist;
import com.example.demo.repositories.PlaylistRepository;
import com.example.demo.services.PlaylistService;
import com.example.demo.services.PlayerService;

public class LoadPlaylistCommand implements ICommand {
    private PlayerService playerService;
    private PlaylistService playlistService;

    public LoadPlaylistCommand(PlayerService playerService, PlaylistService playlistService)
    {
        this.playerService= playerService;
        this.playlistService= playlistService;
    }

    @Override
    public void invoke(List<String> tokens) {
        String name= tokens.get(1);
        String output= playerService.loadPlaylist(name);
        System.out.println(output);
    }
    
}
