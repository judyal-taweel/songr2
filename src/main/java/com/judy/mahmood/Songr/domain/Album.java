package com.judy.mahmood.Songr.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
@Data
@Entity
@Table (name = "Album")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long album_id;

    private String title;
    private String artist;
    private String duration;
    private int no_of_songs;
    private String image_url;

    @OneToMany(mappedBy = "album")
    private List<Songs> songs_list;

    public Album(String title, String artist, String duration, int no_of_songs, String image_url) {
        this.title=title;
        this.artist=artist;
        this.duration=duration;
        this.no_of_songs=no_of_songs;
        this.image_url=image_url;
    }

    public Long getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(Long album_id) {
        this.album_id = album_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getNo_of_songs() {
        return no_of_songs;
    }

    public void setNo_of_songs(int no_of_songs) {
        this.no_of_songs = no_of_songs;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public List<Songs> getSongs_list() {
        return songs_list;
    }

    public void setSongs_list(List<Songs> songs_list) {
        this.songs_list = songs_list;
    }

    public Album(){}
public Album(Long album_id){
        this.album_id=album_id;
}
}
