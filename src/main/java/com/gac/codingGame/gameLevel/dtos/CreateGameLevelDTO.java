package com.gac.codingGame.gameLevel.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateGameLevelDTO {
    @NotBlank
    private String tileSet;

    @NotNull
    @Min(100)
    private Integer canvassHeight;

    @NotNull
    @Min(100)
    private Integer canvassWidth;

    @NotNull
    @Min(1)
    private Long storyId;

    @NotBlank
    private String music;

    public String getTileSet() {
        return tileSet;
    }

    public void setTileSet(String tileSet) {
        this.tileSet = tileSet;
    }

    public Integer getCanvassHeight() {
        return canvassHeight;
    }

    public void setCanvassHeight(Integer canvassHeight) {
        this.canvassHeight = canvassHeight;
    }

    public Integer getCanvassWidth() {
        return canvassWidth;
    }

    public void setCanvassWidth(Integer canvassWidth) {
        this.canvassWidth = canvassWidth;
    }

    public Long getStoryId() {
        return storyId;
    }

    public void setStoryId(Long storyId) {
        this.storyId = storyId;
    }

    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music;
    }
}
