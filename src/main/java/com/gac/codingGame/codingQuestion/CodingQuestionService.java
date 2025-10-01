package com.gac.codingGame.codingQuestion;

import com.gac.codingGame.codingQuestion.dtos.CreateCodingQuestionDTO;
import com.gac.codingGame.codingQuestion.dtos.UpdateCodingQuestionDTO;
import com.gac.codingGame.codingQuestion.entities.CodingQuestion;
import com.gac.codingGame.common.ValidationErrors;
import com.gac.codingGame.common.exceptions.BadRequestException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CodingQuestionService {

    private final CodingQuestionRepository codingQuestionRepository;
    private final ModelMapper mapper;

    public CodingQuestionService(CodingQuestionRepository codingQuestionRepository, ModelMapper mapper) {
        this.codingQuestionRepository = codingQuestionRepository;
        this.mapper = mapper;
    }

    public Optional<CodingQuestion> findById(Long id){
        return this.codingQuestionRepository.findById(id);
    }

    public List<CodingQuestion> findAll( ) {
        return codingQuestionRepository.findAll();
    }

    public CodingQuestion createCodingQuestion(CreateCodingQuestionDTO data) throws Exception {
        ValidationErrors errors = new ValidationErrors();

        CodingQuestion newCodingQuestion = mapper.map(data, CodingQuestion.class);
        if (errors.hasErrors()) {
            throw new BadRequestException("Validation Failed", errors);
        }
        return this.codingQuestionRepository.saveAndFlush(newCodingQuestion);
    }

    // Delete
    public Boolean deleteById(Long id) {
        Optional<CodingQuestion> result = this.findById(id);
        if (result.isEmpty()) {
            return false;
        }
        this.codingQuestionRepository.deleteById(id);
        return true;
    }

    // UPDATE
    public Optional<CodingQuestion> updateById(Long id, UpdateCodingQuestionDTO data) throws BadRequestException {
        Optional<CodingQuestion> result = codingQuestionRepository.findById(id);
        if (result.isEmpty()) {
            return result;
        }
        ValidationErrors errors = new ValidationErrors();
        CodingQuestion toUpdate = result.get();
        mapper.map(data, toUpdate);
        if (errors.hasErrors()) {
            throw new BadRequestException("validation failed", errors);
        }
        this.codingQuestionRepository.save(toUpdate);
        return Optional.of(toUpdate);
    }

}
