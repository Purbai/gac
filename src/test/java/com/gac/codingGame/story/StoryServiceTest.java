package com.gac.codingGame.story;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.mockito.InjectMocks;

import static org.mockito.Mockito.verify;

public class StoryServiceTest {
    @Mock
    private StoryRepository storyRepository;

    @Spy
    @InjectMocks
    private StoryService storyService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

//    now add the test to be performed ....
    @Test
    public void getAllStories_CallsFindAllOnStoryRepo() {
        storyService.findAll();
        verify(storyRepository).findAll();
    }

    @Test
    public void storyById_PassedToFindByInOnStoryRepo(){
        storyService.findById(1L);
        verify(storyRepository).findById(1L);
    }


}
