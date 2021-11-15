package com.example.AppQuiz.controllers;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.example.AppQuiz.dto.QuizesDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import java.util.Optional;
import com.example.AppQuiz.entities.Quizapps;
import com.example.AppQuiz.entities.Answer;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.AppQuiz.service.QuizService;
import com.example.AppQuiz.dto.QuizesDto;

@RestController
@CrossOrigin
public class QuizController {

	@Autowired
	QuizRepository quizRepository;
	@Autowired
	AnswerRepository answerRepository;
	@Autowired
	QuizService quizService;
	
	@RequestMapping(path="/view",method=RequestMethod.GET)
	public List<Quizapps> viewQuiz(){
		System.out.println("fetch all workout method is invoked...");
//		return null;
		return quizRepository.findAll();
	}
	@RequestMapping(path="/add",method=RequestMethod.POST)
	public void addQuiz(@RequestBody Quizapps course){
		 quizRepository.save(course);
		
	}
	@RequestMapping(path = "/delete/{quizid}", method = RequestMethod.DELETE)
	public void deleteQuiz(@PathVariable("quizid")int QuizID){
		 quizRepository.deleteById(QuizID);
		
	}
	@RequestMapping(path="/save",method=RequestMethod.POST)
	public ResponseEntity<Quizapps> findAnswer(@RequestBody QuizesDto quiz){
		ResponseEntity<Quizapps> re= null;
		quizService.saveAnswer(quiz);
		return re= new ResponseEntity<Quizapps> (HttpStatus.OK);	
	}

@RequestMapping(path="/fetchAll",method=RequestMethod.GET)
	public List<Answer> fetchAllAnswer(){
		System.out.println("fetch all answer method is invoked............");
		return answerRepository.findAll();
	}

}
