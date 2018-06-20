package iu.edu.popUp.service;

import java.util.Optional;

import iu.edu.popUp.model.Friend;

public interface FriendService {
	public Friend save(Friend friend);

	public Optional<Friend> findFriend(long uid, long fid);

}
