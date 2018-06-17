package iu.edu.popUp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import iu.edu.popUp.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
	List<Post> findByUserId(long userId);
}
