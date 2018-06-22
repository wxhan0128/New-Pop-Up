package iu.edu.popUp.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import iu.edu.popUp.model.User;
import iu.edu.popUp.service.UserServiceImpl;

@Controller
public class ProfileController {
	private User user;

	@Autowired
	private UserServiceImpl userServiceImpl;

	@GetMapping("/users/{id}/profile")
	public String indexPage(@PathVariable long id, HttpSession session, Model model) {
		user = (User) session.getAttribute("user");
		if (user.getId() != id) {
			User newUser = new User();
			Optional<User> userOptional = this.userServiceImpl.findOne(id);
			if (userOptional.isPresent()) {
				newUser = userOptional.get();
			}

			model.addAttribute("user", newUser);

			return "profile";
		}
		model.addAttribute("user", user);

		return "myProfile";
	}

}
