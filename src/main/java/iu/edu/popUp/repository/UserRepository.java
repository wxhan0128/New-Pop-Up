package iu.edu.popUp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import iu.edu.popUp.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsernameAndPassword(String username, String password);

	Optional<User> findByUsername(String username);

	Optional<User> findByEmail(String email);

	// find users which contain the input username
	List<User> findByUsernameContains(String uname);
}
