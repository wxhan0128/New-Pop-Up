package iu.edu.popUp.service;

import java.util.List;

import iu.edu.popUp.model.Comment;

public interface CommentService {
	public Comment save(Comment comment);

	public List<Comment> findPostComments(long pid);
}
