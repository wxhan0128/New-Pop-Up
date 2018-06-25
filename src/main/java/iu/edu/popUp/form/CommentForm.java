package iu.edu.popUp.form;

import java.util.Date;

import org.springframework.beans.BeanUtils;

import iu.edu.popUp.model.Comment;
import iu.edu.popUp.model.Post;
import iu.edu.popUp.model.User;

public class CommentForm {
	private String content;
	private Date postTime;
	private User user;
	private Post post;

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public Comment convertToComment() {
		Comment comment = new CommentFormConvert().convert(this);

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
