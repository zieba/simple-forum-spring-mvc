package x.zieba.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;



import x.zieba.forum.entity.Topic;

public interface TopicRepository extends JpaRepository<Topic, Integer> {

}
