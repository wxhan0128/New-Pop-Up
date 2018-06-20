package iu.edu.popUp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iu.edu.popUp.model.Friend;
import iu.edu.popUp.repository.FriendRepository;

@Service
public class FriendServiceImpl implements FriendService {
	@Autowired
	private FriendRepository friendRepository;

	@Override
	public Friend save(Friend friend) {
		// TODO Auto-generated method stub
		return this.friendRepository.save(friend);
	}

	@Override
	public Optional<Friend> findFriend(long uid, long fid) {
		// TODO Auto-generated method stub
		return this.friendRepository.findByUserIdAndFriendId(uid, fid);
	}

}
