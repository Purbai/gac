package com.gac.codingGame.gameLevel;

import com.gac.codingGame.common.exceptions.NotFoundException;
import com.gac.codingGame.gameLevel.entities.GameLevel;
import com.gac.codingGame.story.StoryService;
import com.gac.codingGame.story.entities.Story;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class GameLevelControllerTest {
    @Autowired
    private GameLevelController gameLevelController;

    @Autowired
    private GameLevelRepository gameLevelRepository;

    @MockitoBean
    private GameLevelService gameLevelService;

    @MockitoBean
    private StoryService storyService;

    @Test
    void shouldReturnGameLevelWhenFound() throws NotFoundException {

        Story story = new Story("Story Test");

        GameLevel gameLevel = new GameLevel("Test Bunker",100,70,story,"Game Music goes here");
        gameLevel.setId(1L);

        Mockito.when(gameLevelService.findById(1L)).thenReturn(Optional.of(gameLevel));

        ResponseEntity<GameLevel> result = gameLevelController.findById(1L);

        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertNotNull(result.getBody());
        assertEquals("Test Bunker", result.getBody().getTileSet());
        assertEquals(100, result.getBody().getCanvassHeight());
        assertEquals(70, result.getBody().getCanvassWidth());
        assertEquals(story, result.getBody().getStory());
        assertEquals("Game Music goes here", result.getBody().getMusic());

    }
    @Test
    void shouldReturnNotFoundWhenGameLevelMissing() {

        Mockito.when(gameLevelService.findById(99L)).thenReturn(Optional.empty());

        // Assert
        assertThrows(NotFoundException.class,()->{
            gameLevelController.findById(99L);});
    }

}
