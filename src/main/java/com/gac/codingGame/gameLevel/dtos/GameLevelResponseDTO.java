package com.gac.codingGame.gameLevel.dtos;

public class GameLevelResponseDTO {
    private Long id;
    private String tileSet;
    private Integer canvassHeight;
    private Integer canvassWidth;
    private String storyText;
    private String music;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getStoryText() {
        return storyText;
    }

    public void setStoryText(String storyText) {
        this.storyText = storyText;
    }

    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music;
    }
}
