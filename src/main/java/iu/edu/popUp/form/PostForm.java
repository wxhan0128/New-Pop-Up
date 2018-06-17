package iu.edu.popUp.form;

import java.util.Date;

import org.springframework.beans.BeanUtils;

import iu.edu.popUp.model.Post;
import iu.edu.popUp.model.User;

public class PostForm {
	private String content;
	private Date createTime;
	private Date updateTime;

	public PostForm() {
		Date currentTime = new Date();
		this.createTime = currentTime;
		this.updateTime = currentTime;
	}

	public PostForm(String content) {
		this.content = content;
		Date currentTime = new Date();
		this.createTime = currentTime;
		this.updateTime = currentTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Post convertToPost(User user) {
		Post post = new PostFormConvert().convert(this);
		post.setUser(user);

		return post;
	}

	private class PostFormConvert implements FormConvert<PostForm, Post> {

		@Override
		public Post convert(PostForm postForm) {
			// TODO Auto-generated method stub
			Post post = new Post();
			BeanUtils.copyProperties(postForm, post);
			return post;
		}
	}
}
