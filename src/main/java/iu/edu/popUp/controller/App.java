package iu.edu.popUp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import iu.edu.popUp.form.PostForm;
import iu.edu.popUp.model.Comment;
import iu.edu.popUp.model.Post;
import iu.edu.popUp.model.Response;
import iu.edu.popUp.model.User;
import iu.edu.popUp.service.CommentServiceImpl;
import iu.edu.popUp.service.PostServiceImpl;
import iu.edu.popUp.service.UserServiceImpl;

@RestController
@RequestMapping("/api/v1")
public class App {
	private User user;
	private Post post;
	@Autowired
	private UserServiceImpl userServiceImpl;
	@Autowired
	private PostServiceImpl postServiceImpl;
	@Autowired
	private CommentServiceImpl commentServiceImpl;

	private List<Post> postList;
	private List<Comment> commentList;

	@GetMapping("/users/{id}/posts")
	public Response getPosts(@PathVariable long id) {
		Optional<User> userOptional = userServiceImpl.findOne(id);
		if (userOptional.isPresent()) {
			user = userOptional.get();
		}
		postList = user.getPosts();

		Response response = new Response("Done", postList);
		return response;
	}

	@PostMapping("/users/{id}/posts")
	public Response inputPost(@PathVariable long id, @RequestBody PostForm postForm) {
		Optional<User> userOptional = userServiceImpl.findOne(id);
		if (userOptional.isPresent()) {
			user = userOptional.get();
		}
		Post post = postForm.convertToPost(user);
		postServiceImpl.save(post);

		postList = user.getPosts();

		Response response = new Response("Done", postList);
		return response;
	}

	@GetMapping("/posts/{id}/comments")
	public Response getComments(@PathVariable long id) {
		Optional<Post> postOptional = postServiceImpl.findOnePost(id);
		if (postOptional.isPresent()) {
			post = postOptional.get();
		}
		commentList = post.getComments();

		Response response = new Response("Done", commentList);
		return response;
	}
}
