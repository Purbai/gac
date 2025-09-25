package com.gac.codingGame.story.entities;

import jakarta.persistence.*;

@Entity
@Table(name="story")
public class Story {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (columnDefinition = "TEXT", nullable=false)
    private String storyText;

    public Story() {}

    public Story(String storyText) {
        this.storyText = storyText;
    }

    public Long getId() {
        return id;
    }
    public String getStoryText() {
        return storyText;
    }

    public void setStoryText(String storyText) {
        this.storyText = storyText;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
