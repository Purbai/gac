package com.gac.codingGame.gameLevel;

import com.gac.codingGame.common.exceptions.BadRequestException;
import com.gac.codingGame.gameLevel.dtos.CreateGameLevelDTO;
import com.gac.codingGame.gameLevel.entities.GameLevel;
import com.gac.codingGame.common.ValidationErrors;
import com.gac.codingGame.story.StoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameLevelService {

    private final GameLevelRepository gameLevelRepository;
    private final ModelMapper mapper;
    private final StoryService storyService;

    public GameLevelService(GameLevelRepository gameLevelRepository, ModelMapper mapper, StoryService storyService) {
        this.gameLevelRepository = gameLevelRepository;
        this.storyService = storyService;
        this.mapper = mapper;
    }

    public Optional<GameLevel> findById(Long id){
        return this.gameLevelRepository.findById(id);
    }

    public List<GameLevel> findAll( ) {
        return gameLevelRepository.findAll();
    }

    public GameLevel createGameLevel(CreateGameLevelDTO data) throws Exception {
        ValidationErrors errors = new ValidationErrors();
        var result = this.storyService.findById(data.getStoryId());
        if (result.isEmpty()) {
            errors.add("story", "invalid id");
        }
        GameLevel newGameLevel = mapper.map(data, GameLevel.class);
        if (errors.hasErrors()) {
            throw new BadRequestException("Validation Failed", errors);
        }
        newGameLevel.setStory(result.get());
        return this.gameLevelRepository.saveAndFlush(newGameLevel);
    }

    // Delete
    public Boolean deleteById(Long id) {
        Optional<GameLevel> result = this.findById(id);
        if (result.isEmpty()) {
            return false;
        }
        this.gameLevelRepository.deleteById(id);
        return true;
    }
}
