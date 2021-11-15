package com.example.AppQuiz.controllers;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.AppQuiz.entities.Answer;


public interface AnswerRepository extends JpaRepository<Answer, Integer> {

}
