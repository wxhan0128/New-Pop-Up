package iu.edu.popUp.form;

import org.springframework.beans.BeanUtils;

import iu.edu.popUp.model.Liked;

public class LikedForm {
	private long userId;
	private long postId;

	public LikedForm() {

	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getPostId() {
		return postId;
	}

	public void setPostId(long postId) {
		this.postId = postId;
	}

	public Liked convertToLiked() {
		Liked liked = new LikedFormConvert().convert(this);

		return liked;
	}

	private class LikedFormConvert implements FormConvert<LikedForm, Liked> {

		@Override
		public Liked convert(LikedForm likedForm) {
			// TODO Auto-generated method stub
			Liked liked = new Liked();
			BeanUtils.copyProperties(likedForm, liked);
			return liked;
		}
	}
}
