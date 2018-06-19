package iu.edu.popUp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import iu.edu.popUp.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
	@Query("select p from Post p where p.user IN " + "(select f.friendId from Friend f where f.userId=?1) "
			+ "OR p.user=?1 ORDER BY p.createTime DESC")
	List<Post> findAllPostsByUserAndFriend(long userId);

	// find posts which contain the input content
	List<Post> findByContentContains(String content);
}
