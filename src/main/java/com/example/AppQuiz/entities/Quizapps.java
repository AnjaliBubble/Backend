package com.example.AppQuiz.entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Quizapps {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
int id;
String question;
String[] opt;
int answer;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getQuestion() {
	return question;
}
public void setQuestion(String question) {
	this.question = question;
}
public String[] getOpt() {
	return opt;
}
public void setOpt(String[] opt) {
	this.opt = opt;
}
public int getAnswer() {
	return answer;
}
public void setAnswer(int answer) {
	this.answer = answer;
}



}

