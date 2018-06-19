package iu.edu.popUp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iu.edu.popUp.model.Post;
import iu.edu.popUp.model.User;
import iu.edu.popUp.repository.PostRepository;
import iu.edu.popUp.repository.UserRepository;

@Service
public class SearchServiceImpl implements SearchService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PostRepository postRepository;

	@Override
	public List<User> searchUsersByUsername(String username) {
		// TODO Auto-generated method stub
		return this.userRepository.findByUsernameContains(username);
	}

	@Override
	public List<Post> searchPostsByContent(String content) {
		// TODO Auto-generated method stub
		return this.postRepository.findByContentContains(content);
	}

}
