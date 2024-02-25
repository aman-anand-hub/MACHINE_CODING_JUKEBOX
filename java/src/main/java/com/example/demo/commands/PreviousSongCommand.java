package com.example.demo.commands;

import java.util.List;
import com.example.demo.entities.Playlist;
import com.example.demo.repositories.PlaylistRepository;
import com.example.demo.services.PlaylistService;
import com.example.demo.services.PlayerService;

public class PreviousSongCommand implements ICommand{
    private PlayerService playerService;
    private PlaylistService playlistService;

    public PreviousSongCommand(PlayerService playerService, PlaylistService playlistService)
    {
        this.playerService= playerService;
        this.playlistService= playlistService;
    }

    @Override
    public void invoke(List<String> tokens) {
        String output= playerService.previousSong();
        System.out.println(output);
    }       
}
