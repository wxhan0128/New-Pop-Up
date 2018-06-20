package iu.edu.popUp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import iu.edu.popUp.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
	List<Comment> findByPostId(long pid);
}
