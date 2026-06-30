package com.springlearn.ourspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.springlearn.ourspring.dao.music.MusicDaoImpl;
import com.springlearn.ourspring.entity.Music;


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
			getAllMusic(theMusicDao);
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
		System.out.println("List of all music " + theMusicDao.getAllMusic());
	}

}
