package com.springlearn.ourspring.service;

import com.springlearn.ourspring.dao.music.MusicDaoImpl;
import com.springlearn.ourspring.entity.Director;
import com.springlearn.ourspring.repository.DirectorJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class MusicServiceImpl implements MusicService{

    DirectorJPA directorJpa;

    @Autowired
    public void MusicDaoImpl(DirectorJPA theDirectorJpa) {
        this.directorJpa = theDirectorJpa;
    }

    @Override
    public List<Director> getAllDirectors() {
        return this.directorJpa.findAll();
    }

    @Override
    public Director getDirector(int directorId) {

        Optional<Director> director = this.directorJpa.findById(directorId);

        return director.orElseThrow(() -> new RuntimeException("The director " + directorId + " is not available."));
    }

    @Override
    public Director saveDirector(Director theDirector) {
        return null;
    }

    @Override
    public Director updateDirector(int directorId, Map<String, Object> patchPayload) {
        return null;
    }

    @Override
    public boolean deleteDirector(int id) {
        return false;
    }

}
