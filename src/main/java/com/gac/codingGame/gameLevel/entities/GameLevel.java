package com.gac.codingGame.gameLevel.entities;

import com.gac.codingGame.story.entities.Story;
import jakarta.persistence.*;

@Entity
@Table(name="gamelevel")
public class GameLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column ( nullable=false)
    private String tileSet;

    @Column ( nullable=false)
    private Integer canvassHeight;

    @Column ( nullable=false)
    private Integer canvassWidth;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="story_id",nullable = false)
    private Story story;

    @Column ( nullable=false)
    private String music;

    public GameLevel(String tileSet, Integer canvassHeight, Integer canvassWidth, Story story, String music) {
        this.tileSet = tileSet;
        this.canvassHeight = canvassHeight;
        this.canvassWidth = canvassWidth;
        this.story = story;
        this.music = music;
    }

    public GameLevel() {}

    public Long getId() {
        return id;
    }

    public String getTileSet() {
        return tileSet;
    }

    public int getCanvassHeight() {
        return canvassHeight;
    }

    public int getCanvassWidth() {
        return canvassWidth;
    }

    public Story getStory() {
        return story;
    }

    public String getMusic() {
        return music;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTileSet(String tileSet) {
        this.tileSet = tileSet;
    }

    public void setCanvassHeight(Integer canvassHeight) {
        this.canvassHeight = canvassHeight;
    }

    public void setCanvassWidth(Integer canvassWidth) {
        this.canvassWidth = canvassWidth;
    }

    public void setStory(Story story) {
        this.story = story;
    }

    public void setMusic(String music) {
        this.music = music;
    }
}
