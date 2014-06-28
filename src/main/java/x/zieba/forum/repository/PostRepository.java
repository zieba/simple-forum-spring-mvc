package x.zieba.forum.repository;


import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import x.zieba.forum.entity.Post;
import x.zieba.forum.entity.User;

public interface PostRepository extends JpaRepository<Post, Integer> {

	List<Post> findByUser(User user, Pageable pagealbe);

}
