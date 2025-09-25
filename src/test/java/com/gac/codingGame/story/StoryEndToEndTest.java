package com.gac.codingGame.story;

import com.gac.codingGame.story.entities.Story;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

    @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
    @ActiveProfiles("test")
    public class StoryEndToEndTest {

        @LocalServerPort
        private int port;

        @Autowired
        private TestRestTemplate restTemplate;

        @Autowired
        private StoryRepository storyRepository;

        @Test
        void shouldReturnStoryFromDatabase() {
            // Arrange: insert story into DB
            Story saved = storyRepository.save(new Story("Integration Test Story"));

            // Act
            Story response = this.restTemplate.getForObject(
                    "http://localhost:" + port + "/api/story/" + saved.getId(),
                    Story.class);

            // Assert
            assertThat(response.getStoryText()).isEqualTo("Integration Test Story");
        }
    }

