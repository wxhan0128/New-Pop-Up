package iu.edu.popUp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iu.edu.popUp.model.Comment;
import iu.edu.popUp.repository.CommentRepository;

@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	private CommentRepository commentRepository;

	@Override
	public Comment save(Comment comment) {
		// TODO Auto-generated method stub
		return this.commentRepository.save(comment);
	}

	@Override
	public List<Comment> findPostComments(long pid) {
		// TODO Auto-generated method stub
		return this.commentRepository.findByPostId(pid);
	}

}
