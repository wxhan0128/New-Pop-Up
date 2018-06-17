package iu.edu.popUp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import iu.edu.popUp.model.Liked;

public interface LikedRepository extends JpaRepository<Liked, Long> {
	Optional<Liked> findByUserIdAndPostId(long uid, long pid);

	List<Liked> findByPostId(long pid);
}
