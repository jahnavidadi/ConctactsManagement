package com.contacts.app.controllers;

import com.contacts.app.entity.User;
import com.contacts.app.model.SignIn;
import com.contacts.app.model.SignUp;
import com.contacts.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;


@Controller
public class SignInController {
	@Autowired
	UserRepository userRepo;

	@GetMapping("/login")
	public String signIn(Model model) {
		model.addAttribute("signin", new SignIn());
		return "signin";
	}

	@PostMapping("/login")
	public String signIn(@ModelAttribute SignIn signIn, Model model, RedirectAttributes redirectAttributes) {
		Optional<User> optionalUser = userRepo.findByEmail(signIn.getEmail());
		if (!optionalUser.isPresent()){
			model.addAttribute("error", "User not found");
			model.addAttribute("signin", new SignIn());
			return "signin";
		}
		User user = optionalUser.get();
		if(!user.getPassword().equals(signIn.getPassword())){
			model.addAttribute("error", "Email or Password not matching");
			model.addAttribute("signin", new SignIn());
			return "signin";
		}
		redirectAttributes.addAttribute("user",user);

		return "redirect:/welcome";
	}
}
