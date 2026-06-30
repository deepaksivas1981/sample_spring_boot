package com.springlearn.ourspring.dao.music;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.springlearn.ourspring.entity.Music;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
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

    @Override
    public Music getMusic(long id) {
        
        return this.entityManager.find(Music.class, id);
    }

    @Override
    public List<Music> getAllMusic() {
        
        TypedQuery<Music> query = entityManager.createQuery("FROM Music", Music.class);

        return query.getResultList();
    }

}
