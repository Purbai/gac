package com.gac.codingGame.story;

import com.gac.codingGame.story.entities.Story;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoryService {
    private final StoryRepository storyRepository;

    public StoryService(StoryRepository storyRepository) {
        this.storyRepository = storyRepository;
    }

    public Optional<Story> findById(Long id){
        return this.storyRepository.findById(id);
    }

    public List<Story> findAll( ) {
        return storyRepository.findAll();
    }
}
