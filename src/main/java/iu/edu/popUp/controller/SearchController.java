package iu.edu.popUp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import iu.edu.popUp.model.Post;
import iu.edu.popUp.model.User;
import iu.edu.popUp.service.SearchServiceImpl;

@Controller
public class SearchController {
	@Autowired
	private SearchServiceImpl searchServiceImpl;

	@GetMapping("/search/results")
	public String searchPage() {
		return "search";
	}

	@PostMapping("/search/input")
	public String basicSearch(@RequestParam String input, RedirectAttributes attributes) {
		List<User> userList = this.searchServiceImpl.searchUsersByUsername(input);
		List<Post> postList = this.searchServiceImpl.searchPostsByContent(input);
		if (userList.size() > 0 || postList.size() > 0) {
			int count = userList.size() + postList.size();
			attributes.addFlashAttribute("message", "have found the following" + count + " results for you");
			attributes.addFlashAttribute("userList", userList);
			attributes.addFlashAttribute("postList", postList);
		} else {
			attributes.addFlashAttribute("message", "cannot find anything");
		}

		return "redirect:/search/results";
	}

	@PostMapping("/search/input/conditions")
	public String conditionalSearch() {
		return "redirect:/search/results";
	}
}
