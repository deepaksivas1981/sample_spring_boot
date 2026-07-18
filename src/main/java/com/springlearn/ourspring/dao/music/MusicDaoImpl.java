package com.springlearn.ourspring.dao.music;

import java.util.List;
import java.util.Optional;

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

    @Transactional
    @Override
    public Optional<Music> updateMusicTitle(String title, int id) {

        // Update th music title
        Music music = entityManager.find(Music.class, id);

        if (music == null) {
            System.out.println("Please confirm the music id!!");
        }
        else {
            music.setName(title);
            entityManager.merge(music);
            return Optional.of(music);
        }
        return Optional.empty();
    }

    @Transactional
    @Override
    public void updateAllAuthor(String author) {
        entityManager.createQuery("UPDATE Music SET author = :author")
                .setParameter("author", author)
                .executeUpdate();
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        // Get the Music
        Music music = entityManager.find(Music.class, id);
        entityManager.remove(music);
    }

    @Transactional
    @Override
    public void deleteAll() {
        int noRowsDeleted = entityManager.createQuery("DELETE FROM Music").executeUpdate();

        System.out.println("Rows deleted " + noRowsDeleted);
    }

    @Transactional
    @Override
    public void deleteByAuthor(String author) {
        entityManager.createQuery("DELETE FROM Music WHERE author = :author")
                .setParameter("author", author)
                .executeUpdate();
    }

}
