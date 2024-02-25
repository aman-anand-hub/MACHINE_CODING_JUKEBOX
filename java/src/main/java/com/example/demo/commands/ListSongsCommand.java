package com.example.demo.commands;

import java.util.List;
import com.example.demo.entities.Song;
import com.example.demo.repositories.SongRepository;
import com.example.demo.services.SongService;

public class ListSongsCommand implements ICommand{
    private final SongService songService; 

    public ListSongsCommand(SongService songService) {
        this.songService = songService;
    }

    @Override
    public void invoke(List<String> tokens) {
        List<String> allSongsList= songService.list_Songs();
        System.out.println(allSongsList);
    }
}
