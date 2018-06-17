package iu.edu.popUp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iu.edu.popUp.model.User;
import iu.edu.popUp.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		return this.userRepository.save(user);
	}

	@Override
	public Optional<User> findUser(String username, String password) {
		// TODO Auto-generated method stub
		return this.userRepository.findByUsernameAndPassword(username, password);
	}

	@Override
	public Optional<User> findUsername(String username) {
		// TODO Auto-generated method stub
		return this.userRepository.findByUsername(username);
	}

	@Override
	public Optional<User> findEmail(String email) {
		// TODO Auto-generated method stub
		return this.userRepository.findByEmail(email);
	}

	@Override
	public Optional<User> findOne(long id) {
		// TODO Auto-generated method stub
		return this.userRepository.findById(id);
	}

}
