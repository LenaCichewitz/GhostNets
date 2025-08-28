package com.ipwa02.ghost_nets.Repository;

import com.ipwa02.ghost_nets.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findUserByUsername(String username);


}