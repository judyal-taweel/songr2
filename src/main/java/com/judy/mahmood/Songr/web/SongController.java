package com.judy.mahmood.Songr.web;

import com.judy.mahmood.Songr.domain.Album;
import com.judy.mahmood.Songr.domain.Songs;
import com.judy.mahmood.Songr.infrastructure.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SongController {
    @Autowired
    private SongRepository songRepository;
//    @GetMapping("/song")
//    public String getAllSong(Model model){
//Songs song1 = new Songs("Like Dylan In The Movies","5:52", 2L);
//Songs song2 = new Songs("One Shine","6:52",4L);
//Songs song3 = new Songs("I Will Survive","9:52",3L);
//        Songs[] songsModel = new Songs[]{song1,song2,song3};
//        model.addAttribute("songs", songsModel);
//        songRepository.findAll();
//        return "songs";
//    }
    @PostMapping("/songs")
    public ResponseEntity createSong(@RequestParam Long track_number, @RequestParam String song_title, @RequestParam String song_length, Album album){
        Songs songModel = new Songs(song_title,song_length,track_number, album);
        Songs savedSong = songRepository.save(songModel);
        return new ResponseEntity(savedSong, HttpStatus.CREATED);
    }
    @RequestMapping(value="/songs/{id}",method= RequestMethod.GET)
    public String getSong(Model model, @PathVariable (value ="id") Long id){
        Songs songById=songRepository.getById(id);
        model.addAttribute("songs", songById);
        return "songs";
    }
}
