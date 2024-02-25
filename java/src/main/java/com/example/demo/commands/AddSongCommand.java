package com.example.demo.commands;

import java.util.List;

import com.example.demo.entities.Song;
import com.example.demo.repositories.SongRepository;
import com.example.demo.services.SongService;

public class AddSongCommand implements ICommand {
    private final SongService songService; 

    public AddSongCommand(SongService songService) {
        this.songService = songService;
    }

    @Override
    public void invoke(List<String> tokens) {
        String name= tokens.get(1);
        String artist= tokens.get(2);
        String album= tokens.get(3);
        String genre= tokens.get(4);
        String songName= songService.addSong(name, artist, album, genre);
        System.out.println(songName);
    }
}
