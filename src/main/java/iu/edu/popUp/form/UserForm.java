package iu.edu.popUp.form;

import java.util.Random;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.beans.BeanUtils;

import iu.edu.popUp.model.User;

public class UserForm {
	public static final String REGEX_USERNAME = "^[a-zA-Z0-9]{5,20}$";
	public static final String REGEX_PASSWORD = "^[a-zA-Z0-9]{6,20}$";
	public static final String REGEX_MOBILE = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";

	@NotBlank
	@Pattern(regexp = REGEX_USERNAME)
	private String username;
	@Length(min = 6, message = "password length should be at least 6")
	@Pattern(regexp = REGEX_PASSWORD)
	private String password;
	private String confirmPassword;
	@NotBlank
	@Email
	private String email;
	@Pattern(regexp = REGEX_MOBILE)
	private String phone;
	private String avatar;

	public UserForm() {
		Random random = new Random();
		int index = random.nextInt(16) + 1;
		String avatarUrl = "/images/defaultProfileImgs/head" + index + ".png";

		this.avatar = avatarUrl;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public boolean confirmPassword() {
		if (this.password.equals(this.confirmPassword)) {
			return true;
		}

		return false;
	}

	public User convertToUser() {
		User user = new UserFormConvert().convert(this);

		return user;
	}

	private class UserFormConvert implements FormConvert<UserForm, User> {

		@Override
		public User convert(UserForm userForm) {
			// TODO Auto-generated method stub
			User user = new User();
			BeanUtils.copyProperties(userForm, user);
			return user;
		}
	}

}
