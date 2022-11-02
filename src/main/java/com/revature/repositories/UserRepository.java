package com.revature.repositories;

import com.revature.entities.Role;
import com.revature.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserByUsername(String username);
    List<User> findUsersByRole(Role role);
}
