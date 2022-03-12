package com.contacts.app.controllers;

import com.contacts.app.entity.User;
import com.contacts.app.helper.ContactHelper;
import com.contacts.app.model.SignIn;
import com.contacts.app.model.SignUp;
import com.contacts.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class SignUPController {
	@Autowired
	UserRepository userRepo;

	@Autowired
	ContactHelper helper;

	@GetMapping("/signup")
	public String signUP(Model model) {
		model.addAttribute("signup", new SignUp());
		return "signup";
	}

	@PostMapping("/signup")
	public String signUPSubmit(@ModelAttribute SignUp signUp, Model model) {
		boolean validFormData = helper.validateFormData(signUp);
		if (!validFormData){
			model.addAttribute("error", "Email already Exists");
			model.addAttribute("signup", new SignUp());
			return "signup";
		}
		userRepo.save(new User(signUp.getEmail(),signUp.getPassword(),signUp.getSecret()));
		model.addAttribute("signup", signUp);
		return "result";
	}
}
