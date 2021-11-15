package com.example.AppQuiz.service;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AppQuiz.dto.QuizesDto;
import com.example.AppQuiz.entities.Answer;
import com.example.AppQuiz.entities.Quizapps;
import com.example.AppQuiz.controllers.AnswerRepository;
import com.example.AppQuiz.controllers.QuizRepository;
@Transactional
@Service
public class QuizService {
	@Autowired
	private QuizRepository quizrepos;
	
	@Autowired
	private AnswerRepository answerRepo;

	public Boolean saveAnswer(QuizesDto quizDto){
		Optional<Quizapps> quizEntity =quizrepos.findById(quizDto.getId());

		if(quizEntity.isPresent()) {
			Quizapps qen=new Quizapps();
			qen=quizEntity.get();
			Integer quiz= quizrepos.getAnswerById(qen.getId());
			Answer answerEntity=new Answer();
			answerEntity.setActualAnsId(quiz);
			answerEntity.setAnswerId(quizDto.getAnswer());
			answerEntity.setQstId(quizDto.getId());
			answerRepo.save(answerEntity);
			return true;
		}
		return false;
	}

}
