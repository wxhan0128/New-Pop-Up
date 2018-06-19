package iu.edu.popUp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import iu.edu.popUp.model.Friend;
import iu.edu.popUp.model.User;
import iu.edu.popUp.service.FriendServiceImpl;

@Controller
public class ConnectController {
	private User curUser;
	@Autowired
	private FriendServiceImpl friendServiceImpl;

	@PostMapping("/friend/add")
	public String addFriend(HttpSession session, @RequestParam long friendId) {
		curUser = (User) session.getAttribute("user");
		Friend friend = new Friend();
		friend.setUserId(curUser.getId());
		friend.setFriendId(friendId);
		this.friendServiceImpl.save(friend);

		return "redirect:/index";
	}

}
