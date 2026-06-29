package com.springlearn.ourspring.dao.music;

import org.springframework.stereotype.Repository;

import com.springlearn.ourspring.entity.Music;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class MusicDaoImpl implements MusicDao{

    EntityManager entityManager;

    MusicDaoImpl(EntityManager theEntityManager) {
        this.entityManager = theEntityManager; 
    }

    @Transactional
    @Override
    public void save(Music music) {
        
        // Save music
        this.entityManager.persist(music);
        
    }

}
