package com.gac.codingGame.gameLevel;

import com.gac.codingGame.gameLevel.entities.GameLevel;
import com.gac.codingGame.story.entities.Story;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameLevelRepository extends JpaRepository<GameLevel, Long> {
    Integer countByStory(Story story);
}
