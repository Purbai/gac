package com.gac.codingGame.codingQuestion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import static org.mockito.Mockito.verify;

public class CodingQuestionServiceTest {
    @Mock
    private CodingQuestionRepository codingQuestionRepository;

    @Spy
    @InjectMocks
    private CodingQuestionService codingQuestionService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getAllCodingQuestions_CallsFindAllOnCodingQuestionRepo(){
        codingQuestionService.findAll();
        verify(codingQuestionRepository.findAll());
    }
    @Test
    public void codingQuestionById_PassedToFindByIdOnCodingQuestionRepo(){
        codingQuestionService.findById(1L);
        verify(codingQuestionRepository).findById(1l);
    }
}
