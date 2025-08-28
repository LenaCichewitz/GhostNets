package com.ipwa02.ghost_nets.Service;

import com.ipwa02.ghost_nets.Model.User;
import com.ipwa02.ghost_nets.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String loginValidation(String username) {
        User user = userRepository.findUserByUsername(username);
        if(user==null) {
          return "Username is incorrect";
        }
        return null;
    }
    public String login(String username, String password) {
        User user = userRepository.findUserByUsername(username);
        if(!user.getPassword().equals(password)) {
            return "Wrong password";
        }

        return null;
    }
}