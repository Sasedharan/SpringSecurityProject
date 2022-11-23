package com.em.ProjectSpringBoot.Repository;

import com.em.ProjectSpringBoot.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
