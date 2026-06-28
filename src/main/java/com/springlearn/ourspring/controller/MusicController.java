package com.springlearn.ourspring.controller;

import com.springlearn.ourspring.music.Carnatic;
import com.springlearn.ourspring.music.Music;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MusicController {

    @Value("${creator.name}")
    private String creator;

    @Value("${creator.company}")
    private String creatorCompany;

    private Music music;
    private Music anotherMusic;

    @Autowired
    MusicController(
            @Qualifier("carnatic") Music theMusic,
            @Qualifier("carnatic") Music anotherMusic) {
        this.music = theMusic;
        this.anotherMusic = anotherMusic;
    }

    @GetMapping("/")
    public String getMessage() {

        return music.getMusicTheme();
    }

    @GetMapping("/check")
    public String checkClass() {
        return "Music is same ? " + ( this.music == this.anotherMusic );
    }
}
