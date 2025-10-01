package com.gac.codingGame.codingQuestion;

import com.gac.codingGame.common.exceptions.NotFoundException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CodingQuestionControllerTest {
    @Autowired
    private CodingQuestionController codingQuestionController;

    @Autowired
    private CodingQuestionRepository codingQuestionRepository;

    @MockitoBean
    private CodingQuestionService codingQuestionService; //mocked service

//    @Test
//    void testFindById(){
//        CodingQuestion codingQuestion = new CodingQuestion();
//        codingQuestion.setId(1L);
//        Mockito.when(codingQuestionService.findById(1L)).thenReturn(Optional.of(codingQuestion));
//        ResponseEntity<GameLevel> result = codingQuestionController.findById(1L);
//
//        assertEquals(HttpStatus.OK, result.getStatusCode());
//        assertNotNull(result.getBody());
//        assertEquals("Test Bunker", result.getBody().getTileSet());
//        assertEquals(100, result.getBody().getCanvassHeight());
//        assertEquals(70, result.getBody().getCanvassWidth());
//        assertEquals("Game Music goes here", result.getBody().getMusic());
//        assertEquals("twoSum", result.get().getFunctionName());
//    }

    @Test
    void shouldReturnNotFoundWhenCodingQuestionMissing() {

        Mockito.when(codingQuestionService.findById(99L)).thenReturn(Optional.empty());

        // Assert
        assertThrows(NotFoundException.class,()->{
            codingQuestionController.findById(99L);});
    }
}
