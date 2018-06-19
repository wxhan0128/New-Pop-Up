package iu.edu.popUp.service;

import java.util.List;

import iu.edu.popUp.model.Post;
import iu.edu.popUp.model.User;

public interface SearchService {
	public List<User> searchUsersByUsername(String username);

	public List<Post> searchPostsByContent(String content);
}
