package iu.edu.popUp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iu.edu.popUp.model.Post;
import iu.edu.popUp.repository.PostRepository;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository postRepository;

	@Override
	public Post save(Post post) {
		// TODO Auto-generated method stub
		return postRepository.save(post);
	}

	@Override
	public List<Post> findAllPosts(long user_id) {
		// TODO Auto-generated method stub
		return postRepository.findAllPostsByUserAndFriend(user_id);
	}

	@Override
	public Optional<Post> findOnePost(long id) {
		// TODO Auto-generated method stub
		return this.postRepository.findById(id);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		postRepository.deleteById(id);
	}

}
