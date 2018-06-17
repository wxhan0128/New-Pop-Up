package iu.edu.popUp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iu.edu.popUp.model.Liked;
import iu.edu.popUp.repository.LikedRepository;

@Service
public class LikedServiceImpl implements LikedService {
	@Autowired
	private LikedRepository likedRepository;

	@Override
	public Liked save(Liked liked) {
		// TODO Auto-generated method stub
		return likedRepository.save(liked);
	}

	@Override
	public Optional<Liked> findLiked(long uid, long pid) {
		// TODO Auto-generated method stub
		return likedRepository.findByUserIdAndPostId(uid, pid);
	}

	@Override
	public List<Liked> findAllLiked(long pid) {
		// TODO Auto-generated method stub
		return likedRepository.findByPostId(pid);
	}

}
