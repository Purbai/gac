package com.gac.codingGame.gameLevel;

import com.gac.codingGame.gameLevel.dtos.CreateGameLevelDTO;
import com.gac.codingGame.common.exceptions.BadRequestException;
import com.gac.codingGame.story.StoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.Optional;

//@ExtendWith(MockitoExtension.class)
public class GameLevelServiceTest {
    @Mock
    private GameLevelRepository gameLevelRepository;
    @Mock
    private StoryService storyService;

    @Spy
    @InjectMocks
    private GameLevelService gameLevelService;


    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    //    now add the test to be performed ....
    @Test
    public void getAllGameLevels_CallsFindAllOnGameLevelRepo() {
        gameLevelService.findAll();
        verify(gameLevelRepository).findAll();
    }

    @Test
    public void gameLevelById_PassedToFindByInOnGameLevelRepo(){
        gameLevelService.findById(1L);
        verify(gameLevelRepository).findById(1L);
    }

//    @Test
//    public void createGameLevel_AllConditionsAreMet_IsSuccessful() throws Exception{
//        CreateGameLevelDTO mCreateGameLevelDTO = new CreateGameLevelDTO();
//        mCreateGameLevelDTO.setStoryId(1L);
//        mCreateGameLevelDTO.setCanvassHeight(100);
//        mCreateGameLevelDTO.setCanvassWidth(100);
//        mCreateGameLevelDTO.setMusic("Music lives here!");
//        mCreateGameLevelDTO.setTileSet("Tileset of the Game");
//        Story mockStory = new Story();
//        when(storyService.findById(1L)).thenReturn(Optional.of(mockStory));
//        when(gameLevelRepository.countByStory(mockStory)).thenReturn(0);
//
//        GameLevel mockGameLevel = new GameLevel();
//        when(gameLevelRepository.saveAllAndFlush(any(GameLevel.class))).thenReturn(mockGameLevel);
//
//        GameLevel result = GameLevelService.createGameLevel(mCreateGameLevelDTO);
//        assertNotNull(result);
//        verify(gameLevelRepository,times(1)).saveAllAndFlush(any(GameLevel.class));
//
//    }

//    @Test
//    public void createGameLevel_AllConditionsAreNotMet_IsFailure() {
//        CreateGameLevelDTO mCreateGameLevelDTO = new CreateGameLevelDTO();
//        mCreateGameLevelDTO.setStoryId(1L);
//        mCreateGameLevelDTO.setCanvassHeight(100);
//        mCreateGameLevelDTO.setCanvassWidth(100);
//        mCreateGameLevelDTO.setMusic("Music lives here!");
//        mCreateGameLevelDTO.setTileSet("Tileset of the Game");
//
//        when(storyService.findById(1L)).thenReturn(Optional.empty());
//
//        assertThrows(BadRequestException.class,()->gameLevelService.createGameLevel(mCreateGameLevelDTO));
//    }

}
