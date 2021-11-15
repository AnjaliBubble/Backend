package com.example.AppQuiz.controllers;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import java.util.Optional;
import com.example.AppQuiz.entities.Quizapps;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.AppQuiz.entities.Login;
@RestController
@CrossOrigin
public class LoginController {
	@Autowired
	LoginRepository loginRepo;
	@PostMapping("/login")
	public Login login(@RequestBody Login login)throws Exception
	{
		System.out.println("Login method is invoked...........................");
		Login login_obj= null; 
		String temp_username= login.getUsername();
		String temp_password= login.getPassword();
		if(temp_username != null && temp_password!=null){
			login_obj= loginRepo.findBy_usernameAndpassword(temp_username,temp_password);
			System.out.println("Login Token:"+login_obj);
		}
		
		if(login_obj==null){
					throw new Exception("Invalid Credentials");
				}
				return login_obj;
			}

}
