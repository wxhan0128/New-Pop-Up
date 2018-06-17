package iu.edu.popUp.service;

import java.util.List;
import java.util.Optional;

import iu.edu.popUp.model.Liked;

public interface LikedService {

	public Liked save(Liked liked);

	public Optional<Liked> findLiked(long uid, long pid);

	public List<Liked> findAllLiked(long pid);
}
