package com.judy.mahmood.Songr.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table (name = "songs")
public class Songs {
    private String song_title;
    private String song_length;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long track_number;

    @ManyToOne
    @JoinColumn(name = "album")
    private Album album;

    public Songs(String song_title, String song_length, Long track_number , Album album) {
        this.song_title = song_title;
        this.song_length = song_length;
        this.track_number = track_number;
        this.album=album;
    }
    public Songs(){}



    public String getSong_title() {
        return song_title;
    }

    public void setSong_title(String song_title) {
        this.song_title = song_title;
    }

    public String getSong_length() {
        return song_length;
    }

    public void setSong_length(String song_length) {
        this.song_length = song_length;
    }

    public Long getTrack_number() {
        return track_number;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public void setTrack_number(Long track_number) {
        this.track_number = track_number;
    }
}
