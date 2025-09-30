package com.gac.codingGame.seeder;

import com.gac.codingGame.gameLevel.GameLevelRepository;
import com.gac.codingGame.gameLevel.entities.GameLevel;
import com.gac.codingGame.story.StoryRepository;
import com.gac.codingGame.story.entities.Story;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class GameLevelDataSeeder implements CommandLineRunner {

    private final GameLevelRepository gameLevelRepository;
    private final StoryRepository storyRepository;

    public GameLevelDataSeeder(GameLevelRepository gameLevelRepository, StoryRepository storyRepository) {
        this.gameLevelRepository = gameLevelRepository;
        this.storyRepository = storyRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (gameLevelRepository.count() == 0) {
            Story storyId = storyRepository.findById(1L).orElseThrow();
            String tileSet = "Bunker";
            Integer canvassHeight = 100;
            Integer canvassWidth = 100;
            String music = "link to the music";
            gameLevelRepository.saveAndFlush(new GameLevel(tileSet, canvassHeight, canvassWidth, storyId, music));
        }

    }
}

