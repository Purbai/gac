package com.gac.codingGame.codingQuestion;

import com.gac.codingGame.codingQuestion.dtos.CodingQuestionResponseDTO;
import com.gac.codingGame.codingQuestion.dtos.CreateCodingQuestionDTO;
import com.gac.codingGame.codingQuestion.dtos.UpdateCodingQuestionDTO;
import com.gac.codingGame.codingQuestion.entities.CodingQuestion;
import com.gac.codingGame.common.exceptions.BadRequestException;
import com.gac.codingGame.common.exceptions.NotFoundException;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/codingquestion")
public class CodingQuestionController {
    public final CodingQuestionService codingQuestionService;
    public final ModelMapper mapper;


    public CodingQuestionController(CodingQuestionService codingQuestionService, ModelMapper mapper) {
        this.codingQuestionService = codingQuestionService;
        this.mapper = mapper;
    }

    @PostMapping()
    public ResponseEntity<CodingQuestionResponseDTO> createCodingQuestion(@RequestBody @Valid CreateCodingQuestionDTO data) throws Exception{
        CodingQuestion createdCodingQuestion = this.codingQuestionService.createCodingQuestion(data);
        CodingQuestionResponseDTO response = mapper.map(createdCodingQuestion,CodingQuestionResponseDTO.class);
        return new ResponseEntity<CodingQuestionResponseDTO>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public List<CodingQuestion> findAll() {return this.codingQuestionService.findAll();}

    @GetMapping("/{id}")
    public ResponseEntity<CodingQuestion> findById(@PathVariable Long id) throws NotFoundException {
        return codingQuestionService.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(()-> new NotFoundException("CodingQuestion not found with id " + id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CodingQuestionResponseDTO> updateById(@PathVariable Long id, @RequestBody @Valid UpdateCodingQuestionDTO data) throws NotFoundException, BadRequestException
    {
        CodingQuestion updatedCodingQuestion = this.codingQuestionService.updateById(id,data)
                .orElseThrow(() -> new NotFoundException("Could not find book with id "+id));
        CodingQuestionResponseDTO response = mapper.map(updatedCodingQuestion,CodingQuestionResponseDTO.class);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public String deleteCodingQuestion(@PathVariable Long id) {
        codingQuestionService.deleteById(id);
        return String.format("CodingQuestion with ID %d has been deleted", id );
    }
}