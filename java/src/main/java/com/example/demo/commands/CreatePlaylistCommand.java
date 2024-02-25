package com.example.demo.commands;

import java.util.ArrayList;
import java.util.List;
import javax.swing.Icon;
import com.example.demo.entities.Playlist;
import com.example.demo.repositories.PlaylistRepository;
import com.example.demo.services.PlayerService;
import com.example.demo.services.PlaylistService;

public class CreatePlaylistCommand implements ICommand {
    private final PlaylistService playlistService; 

    public CreatePlaylistCommand(PlaylistService playlistService)
    { 
        this.playlistService = playlistService;
    }

    @Override
    public void invoke(List<String> tokens) {
        String name= "";
        Integer n= tokens.size();
        List<Long> songIds= new ArrayList<>();
        for(Integer i=1; i<n; i++)
        {
            if(i==1)
            {
                name= tokens.get(i);
                continue;
            }
            else
            {
                songIds.add(Long.parseLong(tokens.get(i)));
            }
        }
        
        String playlistS= playlistService.createPlaylist(name, songIds);
        System.out.println(playlistS);
    }

}
