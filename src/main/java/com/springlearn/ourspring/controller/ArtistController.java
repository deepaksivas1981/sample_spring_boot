package com.springlearn.ourspring.controller;

import com.springlearn.ourspring.entity.Artist;
import com.springlearn.ourspring.exception.ArtistException;
import com.springlearn.ourspring.exceptionResponse.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api")
@RestController
public class ArtistController {

    private List<Artist> artistList = new ArrayList<>();

    public ArtistController() {
        this.artistList.add(new Artist("Shashwat", 80));
        this.artistList.add(new Artist("Jubeen", 81));
    }


    @GetMapping("/artists/{artistId}")
    public Artist getArtist(@PathVariable int artistId){

        // Raise an exception if the artist id is not valid:
        if ( artistId >= this.artistList.size() || artistId < 0 ) {
            throw new ArtistException("The artist id " + artistId + " does not exist.");
        }

        // Get the student
        Artist theArtist = this.artistList.get(artistId);

        // Return the student
        return theArtist;
    }

    @GetMapping("/artists")
    public List<Artist> getArtists() {

        return this.artistList;
    }


}
