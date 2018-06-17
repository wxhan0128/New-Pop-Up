package iu.edu.popUp.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import iu.edu.popUp.form.UserForm;
import iu.edu.popUp.model.User;
import iu.edu.popUp.service.UserServiceImpl;

@Controller
public class LoginController {

	@Autowired
	private UserServiceImpl userServiceImpl;

	@GetMapping("/register")
	public String registerPage(Model model) {
		model.addAttribute("userForm", new UserForm());

		return "register";
	}

	@PostMapping("/register")
	public String register(@Valid UserForm userForm, BindingResult result) {
		if (userServiceImpl.findUsername(userForm.getUsername()).isPresent()) {
			result.rejectValue("username", "usernameError", "this username has already used");
		}
		if (userServiceImpl.findEmail(userForm.getEmail()).isPresent()) {
			result.rejectValue("email", "emailError", "this email has already registered");
		}
		if (!userForm.confirmPassword()) {
			result.rejectValue("confirmPassword", "confirmError", "password not match");
		}
		if (result.hasErrors()) {
			return "register";
		}

		User user = userForm.convertToUser();
		this.userServiceImpl.save(user);

		return "redirect:/login";
	}

	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}

	@PostMapping("/login")
	public String login(@RequestParam String username, @RequestParam String password, HttpSession session,
			ModelMap modelMap) {
		Optional<User> userOptional = this.userServiceImpl.findUser(username, password);
		if (userOptional.isPresent()) {
			User user = userOptional.get();
			session.setAttribute("user", user);

			return "redirect:/index";
		}

		return "login";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");

		return "redirect:/login";
	}
}
