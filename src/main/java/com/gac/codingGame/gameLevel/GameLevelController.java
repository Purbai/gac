package com.gac.codingGame.gameLevel;

import com.gac.codingGame.gameLevel.dtos.CreateGameLevelDTO;
import com.gac.codingGame.gameLevel.dtos.GameLevelResponseDTO;
import com.gac.codingGame.gameLevel.entities.GameLevel;
import com.gac.codingGame.common.exceptions.NotFoundException;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gamelevel")
public class GameLevelController {
    public final GameLevelService gameLevelService;
    public final ModelMapper mapper;

    public GameLevelController(GameLevelService gameLevelService, ModelMapper mapper) {
        this.gameLevelService = gameLevelService;
        this.mapper = mapper;
    }

    @PostMapping()
    public ResponseEntity<GameLevelResponseDTO> createGameLevel(@RequestBody @Valid CreateGameLevelDTO data) throws Exception{
        GameLevel createdGameLevel = this.gameLevelService.createGameLevel(data);
        GameLevelResponseDTO response = mapper.map(createdGameLevel, GameLevelResponseDTO.class);
        return new ResponseEntity<GameLevelResponseDTO>(response, HttpStatus.CREATED);
    }
    @GetMapping
    public List<GameLevel> findAll() {
        return this.gameLevelService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameLevel> findById(@PathVariable Long id) throws NotFoundException {
        return gameLevelService.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(()-> new NotFoundException("GameLevel not found with id " + id));
    }

    @DeleteMapping("/{id}")
    public String deleteGameLevel(@PathVariable Long id) {
        gameLevelService.deleteById(id);
        return String.format("GameLevel with ID %d has been deleted", id );
    }
}
