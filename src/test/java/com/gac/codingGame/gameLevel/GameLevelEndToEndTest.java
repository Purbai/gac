package com.gac.codingGame.gameLevel;

import com.gac.codingGame.config.HibernateTestConfig;
import com.gac.codingGame.gameLevel.dtos.GameLevelResponseDTO;
import com.gac.codingGame.gameLevel.entities.GameLevel;
import com.gac.codingGame.story.StoryRepository;
import com.gac.codingGame.story.entities.Story;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@Import(HibernateTestConfig.class)
public class GameLevelEndToEndTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private GameLevelRepository gameLevelRepository;
    @Autowired
    private StoryRepository storyRepository;

    @Test
    void shouldReturnGameLevelFromDatabase() {
        // Arrange: insert environment into DB
        Story savedStory = storyRepository.save(new Story("Integration Test Story"));
        GameLevel saved = gameLevelRepository.save(new GameLevel("BunkerStory",100,80,savedStory,"Music Link"));

        // Act
        GameLevelResponseDTO response = this.restTemplate.getForObject(
                "http://localhost:" + port + "/api/gamelevel/" + saved.getId(),
                GameLevelResponseDTO.class);

        // Assert
        assertThat(response.getCanvassHeight()).isEqualTo(100);
        assertThat(response.getCanvassWidth()).isEqualTo(80);
        assertThat(response.getMusic()).isEqualTo("Music Link");
        assertThat(response.getTileSet()).isEqualTo("BunkerStory");
    }
}
