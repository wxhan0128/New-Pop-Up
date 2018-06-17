package iu.edu.popUp.service;

import java.util.Optional;

import iu.edu.popUp.model.User;

public interface UserService {
	public User save(User user);

	public Optional<User> findOne(long id);

	public Optional<User> findUser(String username, String password);

	public Optional<User> findUsername(String username);

	public Optional<User> findEmail(String email);
}
