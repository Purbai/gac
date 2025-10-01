package com.gac.codingGame.codingQuestion;

import com.gac.codingGame.codingQuestion.entities.CodingQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CodingQuestionRepository extends JpaRepository<CodingQuestion,Long>{
}
