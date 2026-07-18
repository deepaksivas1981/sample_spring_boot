package com.springlearn.ourspring.service;

import com.springlearn.ourspring.entity.Director;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface MusicService {

    // Get all director
    List<Director> getAllDirectors();

    Director getDirector(int directorId);

    Director saveDirector(Director theDirector);

    Director updateDirector(int directorId, Map<String, Object> patchPayload);

    boolean deleteDirector(int id);

}
