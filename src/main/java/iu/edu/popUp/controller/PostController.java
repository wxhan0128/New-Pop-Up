package iu.edu.popUp.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import iu.edu.popUp.form.CommentForm;
import iu.edu.popUp.form.LikedForm;
import iu.edu.popUp.form.PostForm;
import iu.edu.popUp.model.Comment;
import iu.edu.popUp.model.Liked;
import iu.edu.popUp.model.Post;
import iu.edu.popUp.model.User;
import iu.edu.popUp.service.CommentServiceImpl;
import iu.edu.popUp.service.LikedServiceImpl;
import iu.edu.popUp.service.PostServiceImpl;

@Controller
public class PostController {
	private User user;
	@Autowired
	private PostServiceImpl postServiceImpl;
	@Autowired
	private LikedServiceImpl likedServiceImpl;
	@Autowired
	private CommentServiceImpl commentServiceImpl;

	@GetMapping("/index")
	public String indexPage(HttpSession session, Model model) {
		user = (User) session.getAttribute("user");
		List<Post> postList = postServiceImpl.findAllPosts(user.getId());

		model.addAttribute("user", user);
		model.addAttribute("posts", postList);

		return "index";
	}

	@PostMapping("/posts/input")
	public String postInput(PostForm postForm) {
		Post post = postForm.convertToPost();
		postServiceImpl.save(post);

		return "redirect:/index";
	}

	@PostMapping("/posts/liked/input")
	public String likePost(LikedForm likedForm) {
		Liked liked = new Liked();
		Optional<Liked> likedOprional = likedServiceImpl.findLiked(likedForm.getUserId(), likedForm.getPostId());
		if (!likedOprional.isPresent()) {
			liked = likedForm.convertToLiked();
			likedServiceImpl.save(liked);
		} else {
			liked = likedOprional.get();
		}

		return "redirect:/index";
	}

	@PostMapping("/posts/comment/input")
	public String commentPost(CommentForm commentForm) {
		Comment comment = commentForm.convertToComment();
		this.commentServiceImpl.save(comment);

		return "redirect:/index";
	}
}
