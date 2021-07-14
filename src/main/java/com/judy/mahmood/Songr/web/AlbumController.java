package com.judy.mahmood.Songr.web;

import com.judy.mahmood.Songr.domain.Album;
import com.judy.mahmood.Songr.infrastructure.AlbumRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Controller
public class AlbumController {
    @Autowired
    private AlbumRepository albumRepository;

//    @GetMapping("/album")
//    public String getAllAlbum(Model model){
//
//        Album albumModel1 = new Album("Moonlight","maichle","5:30",7,"https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse1.mm.bing.net%2Fth%3Fid%3DOIP.RMdFUfNe1i78pwWbJg81KAHaHa%26pid%3DApi&f=1");
//        Album albumModel2 = new Album("Spring","jones","6:02",10,"https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse2.mm.bing.net%2Fth%3Fid%3DOIP.mJ4hrNKMi7lHaXdcbkVwiAHaHa%26pid%3DApi&f=1");
//        Album albumModel3 = new Album("Sun Raise","john","4:15",15,"https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse3.mm.bing.net%2Fth%3Fid%3DOIP.BIlkqO504KYHLj__I7ufQgHaHa%26pid%3DApi&f=1");
//        Album[] albumModels = new Album[]{albumModel1, albumModel2, albumModel3};
//        model.addAttribute("albums", albumModels);
//        albumRepository.findAll();
//        return "albums";
//    }
    @PostMapping("/album")
    public ResponseEntity<Album> albumSubmit(@RequestParam String title, @RequestParam String artist,
                                      @RequestParam String image_url, @RequestParam String duration , @RequestParam int no_of_songs, Model model){
        Album albumModel = new Album(title,artist,duration,no_of_songs,image_url);
        albumRepository.findAll();
        Album albums = albumRepository.save(albumModel);
        albumRepository.findAll();
        model.addAttribute("album",albums);
        return new ResponseEntity<>(albumModel, HttpStatus.CREATED);
    }
    @GetMapping("/album/db")
    public String albumDatabase(Model model){
        model.addAttribute("album_db", albumRepository.findAll());
        return "album_db";
    }

    @RequestMapping(value="/album/{id}",method= RequestMethod.GET)
    public String getAlbum(Model model, @PathVariable (value ="id") Long id){
        Album albumbyId=albumRepository.getById(id);
        model.addAttribute("albums",albumbyId);
        return "albums";
    }

}
