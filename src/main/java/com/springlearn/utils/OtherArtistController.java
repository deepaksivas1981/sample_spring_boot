package com.springlearn.utils;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OtherArtistController {

    @GetMapping("/life")
    public String getMessage() {

        return "This is life of great artists";
    }
}
