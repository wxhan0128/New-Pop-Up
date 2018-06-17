package iu.edu.popUp.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import iu.edu.popUp.form.PostForm;
import iu.edu.popUp.model.Liked;
import iu.edu.popUp.model.Post;
import iu.edu.popUp.model.User;
import iu.edu.popUp.service.LikedServiceImpl;
import iu.edu.popUp.service.PostServiceImpl;

@Controller
public class PostController {
	private User user;
	@Autowired
	private PostServiceImpl postServiceImpl;
	@Autowired
	private LikedServiceImpl likedServiceImpl;

	@GetMapping("/index")
	public String indexPage(HttpSession session, Model model) {
		user = (User) session.getAttribute("user");
		List<Post> postList = postServiceImpl.findAll(user.getId());

		model.addAttribute("user", user);
		model.addAttribute("posts", postList);

		return "index";
	}

	@PostMapping("/posts/input")
	public String postInput(HttpSession session, PostForm postForm) {
		user = (User) session.getAttribute("user");
		Post post = postForm.convertToPost(user);
		postServiceImpl.save(post);

		return "redirect:/index";

	}

	@PostMapping("/posts/liked/input")
	public String likePost(HttpSession session, @RequestParam long postId) {
		user = (User) session.getAttribute("user");
		if (!likedServiceImpl.findLiked(user.getId(), postId).isPresent()) {
			Liked liked = new Liked();
			liked.setUserId(user.getId());
			liked.setPostId(postId);
			likedServiceImpl.save(liked);
		}

		return "redirect:/index";
	}
}
