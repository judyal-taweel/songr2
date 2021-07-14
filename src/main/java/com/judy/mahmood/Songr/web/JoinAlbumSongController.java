package com.judy.mahmood.Songr.web;

import com.judy.mahmood.Songr.domain.Album;
import com.judy.mahmood.Songr.domain.Songs;
import com.judy.mahmood.Songr.infrastructure.AlbumRepository;
import com.judy.mahmood.Songr.infrastructure.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class JoinAlbumSongController {
    @Autowired
    private AlbumRepository albumRepository;
    @Autowired
    private SongRepository songRepository;
//private SongServices songServices;

//    @RequestMapping(value="albums/songs/{id}")
//    public List<Songs> getSongByAlbumId(@PathVariable String id){
//        return songServices.getSongByAlbumId(id);
//    }
//    @PostMapping("/songs/album/{id}")
//    public ResponseEntity<Songs> addSongAlbum(@PathVariable Long album_id, Long track_number) {
//        Album album = albumRepository.findById(album_id).orElseThrow();
//        Songs song = songRepository.findById(track_number).orElseThrow();
//        song.setAlbum(album);
//        return new ResponseEntity<>(songRepository.save(song), HttpStatus.OK);
//    }
@RequestMapping(value = "/songs/{id}/albums", method = RequestMethod.POST)

public ResponseEntity<Songs> addStudentDepartment(@RequestParam  Long album_id, Long track_number) {
        Album department = albumRepository.findById(album_id).orElseThrow();

        Songs student = songRepository.findById(track_number).orElseThrow();
        student.setAlbum(department);

        return new ResponseEntity<>(songRepository.save(student), HttpStatus.OK);
    }
}
