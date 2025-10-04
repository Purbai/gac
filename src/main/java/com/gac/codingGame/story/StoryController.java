package com.gac.codingGame.story;

import com.gac.codingGame.story.entities.Story;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/story")
@CrossOrigin(origins = "*")
public class StoryController {
    public final StoryService storyService;

    public StoryController(StoryService storyService) {
        this.storyService = storyService;
    }

    @GetMapping
    public List<Story> findAll() {
        return this.storyService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Story> findById(@PathVariable Long id) {
        Optional<Story> story = this.storyService.findById(id);
        return story;
    }
}
