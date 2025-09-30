package com.gac.codingGame.story;

import com.gac.codingGame.story.entities.Story;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class StoryControllerTest {

    @Autowired
    private StoryController storyController;

    @Autowired
    private StoryRepository storyRepository;

    @MockitoBean
    private StoryService storyService;  // mocked service

    @Test
    void testFindById() {
        Story story = new Story("Hello world");
        story.setId(1L);

        Mockito.when(storyService.findById(1L)).thenReturn(Optional.of(story));

        Optional<Story> result = storyController.findById(1L);

        assertTrue(result.isPresent());
        assertEquals("Hello world", result.get().getStoryText());
    }
}