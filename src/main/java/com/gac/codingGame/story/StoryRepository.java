package com.gac.codingGame.story;

import com.gac.codingGame.story.entities.Story;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoryRepository extends JpaRepository<Story, Long> {
}
