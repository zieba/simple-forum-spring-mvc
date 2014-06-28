package x.zieba.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import x.zieba.forum.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
