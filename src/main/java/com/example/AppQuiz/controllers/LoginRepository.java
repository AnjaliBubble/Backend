package com.example.AppQuiz.controllers;
import com.example.AppQuiz.entities.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LoginRepository extends JpaRepository<Login, Integer> {
	@Query("SELECT n from #{#entityName} n WHERE n.username = ?1 and n.password= ?2")
	public Login findBy_usernameAndpassword(String username,String password);
}
