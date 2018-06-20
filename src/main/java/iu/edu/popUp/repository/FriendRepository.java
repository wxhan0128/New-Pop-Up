package iu.edu.popUp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import iu.edu.popUp.model.Friend;

public interface FriendRepository extends JpaRepository<Friend, Long> {
	Optional<Friend> findByUserIdAndFriendId(long uid, long fid);
}
