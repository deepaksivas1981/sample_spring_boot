package com.springlearn.ourspring.controller;

import com.springlearn.ourspring.entity.Director;
import com.springlearn.ourspring.service.MusicServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/directors")
@RestController
public class DirectorController {

    MusicServiceImpl musicService;

    @Autowired
    public DirectorController(MusicServiceImpl theMusicService) {
        this.musicService = theMusicService;
    }

    // Get all the director
    @GetMapping
    public List<Director> getAllDirector() {
        return this.musicService.getAllDirectors();
    }

    // Get a director Id
    @GetMapping("/{directorId}")
    public Director getDirector(@PathVariable int directorId) {
        return this.musicService.getDirector(directorId);
    }

    // Add a director
    @PostMapping
    public Director createDirector(@RequestBody Director director) {
        System.out.println("Trying to save the director!!");
        return this.musicService.saveDirector(director);
    }

}
