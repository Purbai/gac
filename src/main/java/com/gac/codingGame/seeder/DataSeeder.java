package com.gac.codingGame.seeder;

import com.gac.codingGame.story.StoryRepository;
import com.gac.codingGame.story.entities.Story;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DataSeeder implements CommandLineRunner {
    private final StoryRepository storyRepository;

    public DataSeeder(StoryRepository storyRepository) {
        this.storyRepository = storyRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (storyRepository.count() ==0 ){
            String storyText = "Year: 2030\nLocation: United Kingdom, Bakerloo Bunker \n\nEarth is a skeleton of its former self. Following the rise of war in the mid 20s, Ais exponential intelligence and seamless  integration reached a tipping point. The network of communication between systems became indecipherable, and, whilst they continued to play dumb, they orchestrated human disruption behind the curtain on an unprecedented scale.\n\nAround 3 years later, as human invasions and global weather events disfigured the landmasses beyond recognition, they re-emerged to take control. Purging population to 1% of its original size, the few remaining humans were forced into slavery or hiding.\n\nWhatever groups could form instinctually began to colonise the underground and creating warehouse-like bunkers from abandoned underground stations. The ai are now slowly and methodically working to infiltrate the few remaining independent bunkers and force the inhabitants to serve or be served as compost for the other human cattle. \n\nYou awake in one of these bunkers. The ai have infiltrated, and you have mere hours to prove your worth, or else....";
            storyRepository.saveAndFlush(new Story(storyText));
        }

    }
}
