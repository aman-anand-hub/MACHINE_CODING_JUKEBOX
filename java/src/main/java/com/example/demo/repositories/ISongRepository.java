package com.example.demo.repositories;

import java.util.List;
import javax.swing.SingleSelectionModel;
import com.example.demo.entities.Song;
import com.example.demo.entities.Playlist;
import com.example.demo.entities.Greeting;

public interface ISongRepository {
    Song save(String name, String  artist, String  album, String genre);
    Song findById(Long id);
    Song findByName(String name);
    List<Song> listAll();
}
