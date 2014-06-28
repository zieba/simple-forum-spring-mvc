package x.zieba.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import x.zieba.forum.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
