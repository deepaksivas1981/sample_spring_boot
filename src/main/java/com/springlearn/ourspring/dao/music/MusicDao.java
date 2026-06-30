package com.springlearn.ourspring.dao.music;

import java.util.List;

import com.springlearn.ourspring.entity.Music;

public interface MusicDao {

    public void save(Music music);

    public Music getMusic(long id);

    public List<Music> getAllMusic();
}
