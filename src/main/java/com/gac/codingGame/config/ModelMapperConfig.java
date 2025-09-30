package com.gac.codingGame.config;

import com.gac.codingGame.gameLevel.dtos.CreateGameLevelDTO;
import com.gac.codingGame.gameLevel.dtos.GameLevelResponseDTO;
import com.gac.codingGame.gameLevel.entities.GameLevel;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper(){
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setSkipNullEnabled(true);
        mapper.typeMap(String.class, String.class).setConverter(new StringTrimConverter());
        mapper.typeMap(GameLevel.class, GameLevelResponseDTO.class)
                .addMappings(m-> m.map(src -> src.getStory().getStoryText(), GameLevelResponseDTO::setStoryText));
        mapper.typeMap(CreateGameLevelDTO.class, GameLevel.class)
                .addMappings(m -> m.skip(GameLevel::setId));
        return mapper;
    }

    private class StringTrimConverter implements Converter<String,String> {

        public String convert(MappingContext<String, String> context) {
            if(context.getSource() ==null){
                return null;
            }
            return  context.getSource().trim();
        }
    }
}
