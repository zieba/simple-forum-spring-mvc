package x.zieba.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import x.zieba.forum.entity.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
