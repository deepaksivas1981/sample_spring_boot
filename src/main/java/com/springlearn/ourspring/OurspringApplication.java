package com.springlearn.ourspring;

import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.springlearn.ourspring.dao.music.MusicDaoImpl;
import com.springlearn.ourspring.entity.Music;

import java.util.List;
import java.util.Optional;


@SpringBootApplication(scanBasePackages = {"com.springlearn.ourspring", "com.springlearn.utils"})
public class OurspringApplication {

	public static void main(String[] args) {
		SpringApplication.run(OurspringApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(MusicDaoImpl theMusicDao) {
		return runner -> {
			// saveMusic(theMusicDao);
			// readMusic(theMusicDao);
			// getAllMusic(theMusicDao);
			//updateMusicTitle(theMusicDao);
			// updateMusicAuthor(theMusicDao);
			// deleteById(theMusicDao);
			// deleteAll(theMusicDao);
			// deleteByAuthor(theMusicDao);
			// System.out.println("Hello World!!");
		};
	}

	public void saveMusic(MusicDaoImpl theMusicDao) {

		System.out.println("Executing command line runner!!");
		
		// Create a new Music
		Music newMusic = new Music("Juda Hokai Bhi", "Pritam", "2026-01-01");

		// Save the music
		theMusicDao.save(newMusic);

		System.out.println("The music is saved!!");
	}

	public void readMusic(MusicDaoImpl theMusicDao) {
		// Create a new Music
		Music newMusic = new Music("Toh Phir Aao", "Pritam", "2026-01-01");

		// Get the music Id

		// Save the music
		theMusicDao.save(newMusic);

		// Given music ID
		System.out.println("New music id " + newMusic.getId());

		// Display
		System.out.println("Saved music : " + theMusicDao.getMusic(newMusic.getId()));
	}

	public void getAllMusic(MusicDaoImpl theMusicDao) {

		List<Music> allMusic = theMusicDao.getAllMusic();

		int counter = 0;

		for(Music music : allMusic) {
			System.out.println("Count : " + counter + " "+ music);
			counter += 1;
		}

	}

	public void updateMusicTitle(MusicDaoImpl theMusicDao) {

		String newTitle = "Jadoo hai nasha hain";

		Optional<Music> updatedTitle = theMusicDao.updateMusicTitle(newTitle, 23);

		System.out.println("The title is updated. New music : " + updatedTitle);
	}

	public void updateMusicAuthor(MusicDaoImpl theMusicDao) {

		String newAuthor = "Shashwat Sachdev";

		theMusicDao.updateAllAuthor(newAuthor);
	}

	public void deleteById(MusicDaoImpl theMusicDao) {
		int deletionId = 23;

		theMusicDao.deleteById(deletionId);
		System.out.println("Music deleted!!");
	}

	public void deleteAll(MusicDaoImpl theMusicDao) {

		theMusicDao.deleteAll();
		System.out.println("All Music deleted!!");
	}

	public void deleteByAuthor(MusicDaoImpl theMusicDao) {

		String author = "Bappi";

		theMusicDao.deleteByAuthor(author);
		System.out.println("All Music deleted of " + author);
	}
}
