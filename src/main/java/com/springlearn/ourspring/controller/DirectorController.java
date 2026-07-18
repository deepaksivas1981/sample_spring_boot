package com.springlearn.ourspring.controller;

import com.springlearn.ourspring.entity.Director;
import com.springlearn.ourspring.service.MusicServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    // Fails due to Sprint security
    @PostMapping
    public Director createDirector(@RequestBody Director director) {
        return this.musicService.saveDirector(director);
    }

    // Delete director
    @DeleteMapping("/{directorId}")
    public boolean deleteDirector(@PathVariable int directorId) {
        return this.musicService.deleteDirector(directorId);
    }

    // Update Director
    @PatchMapping("/{directorId}")
    public Director patchDirector(@PathVariable int directorId, @RequestBody Map<String, Object> objectPayload) {
        return this.musicService.updateDirector(directorId, objectPayload);
    }

}
