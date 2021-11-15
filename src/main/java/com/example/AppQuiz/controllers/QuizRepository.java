package com.example.AppQuiz.controllers;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.AppQuiz.entities.Quizapps;

public interface QuizRepository extends JpaRepository<Quizapps, Integer>{
	@Query(value = "select answer from Quizapps where id=?1", nativeQuery = true)
	Integer getAnswerById(int questionId);
}
