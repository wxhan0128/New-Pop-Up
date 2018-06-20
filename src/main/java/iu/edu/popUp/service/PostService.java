package iu.edu.popUp.service;

import java.util.List;
import java.util.Optional;

import iu.edu.popUp.model.Post;

public interface PostService {
	public Post save(Post post);

	public List<Post> findAllPosts(long uid);

	public Optional<Post> findOnePost(long id);

	public void delete(long id);
}
