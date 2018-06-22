package iu.edu.popUp.form;

import java.util.Date;

import org.springframework.beans.BeanUtils;

import iu.edu.popUp.model.Comment;
import iu.edu.popUp.model.Post;
import iu.edu.popUp.model.User;

public class CommentForm {
	private String content;
	private Date postTime;

	public CommentForm() {
		Date currentTime = new Date();
		this.postTime = currentTime;
	}

	public CommentForm(String content) {
		this.content = content;
		Date currentTime = new Date();
		this.postTime = currentTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getPostTime() {
		return postTime;
	}

	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}

	public Comment convertToComment(User user, Post post) {
		Comment comment = new CommentFormConvert().convert(this);
		comment.setPost(post);
		comment.setUser(user);

		return comment;
	}

	private class CommentFormConvert implements FormConvert<CommentForm, Comment> {

		@Override
		public Comment convert(CommentForm commentForm) {
			// TODO Auto-generated method stub
			Comment comment = new Comment();
			BeanUtils.copyProperties(commentForm, comment);
			return comment;
		}
	}

}
