package com.springlearn.ourspring.service;

import com.springlearn.ourspring.dao.music.MusicDaoImpl;
import com.springlearn.ourspring.entity.Director;
import com.springlearn.ourspring.repository.DirectorJPA;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tools.jackson.databind.json.JsonMapper;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class MusicServiceImpl implements MusicService{

    private DirectorJPA directorJpa;
    private JsonMapper jsonMapper;

    @Autowired
    public void MusicDaoImpl(DirectorJPA theDirectorJpa, JsonMapper theJsonMapper) {
        this.directorJpa = theDirectorJpa;
        this.jsonMapper = theJsonMapper;
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

    @Transactional
    @Override
    public Director saveDirector(Director theDirector) {
        return this.directorJpa.save(theDirector);
    }

    @Transactional
    @Override
    public Director updateDirector(int directorId, Map<String, Object> patchPayload)
    {
        // Get the director
        Optional<Director> theDirector = this.directorJpa.findById(directorId);

        // If the director not available, raise exception
        if ( theDirector.isEmpty() ) {
            throw new RuntimeException("The director to update : " + directorId + " is not available.");
        }

        if (patchPayload.containsKey("id")) {
            throw new RuntimeException("The id cannot be as part of payload");
        }

        // If id is there in key then say id is not available
        Director patchDirector = jsonMapper.updateValue(theDirector.get(), patchPayload);

        // Merge the director information.
        return this.directorJpa.save(patchDirector);
    }

    @Transactional
    @Override
    public boolean deleteDirector(int directorId) {

        Optional<Director> director = this.directorJpa.findById(directorId);

        if (director.isEmpty()) {
            throw new RuntimeException("The director " + directorId + " is not available to Delete.");
        }

        directorJpa.delete(director.get());

        return  true;
    }

}
