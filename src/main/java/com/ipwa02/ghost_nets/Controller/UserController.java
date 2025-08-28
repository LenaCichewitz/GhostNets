package com.ipwa02.ghost_nets.Controller;

import com.ipwa02.ghost_nets.Model.User;
import com.ipwa02.ghost_nets.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/login-form")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "login-form";
    }
    @PostMapping("/login")
    public String login(@ModelAttribute User user, Model model) {
        String errorMsg = userService.loginValidation(user.getUsername());
        if (errorMsg!=null){
            model.addAttribute("errorMessage",errorMsg);
            return "login-form";
        }
        errorMsg = userService.login(user.getUsername(),user.getPassword()); /// PW SICHERUNG EINBAUEN TODO
        if(errorMsg!=null){
            model.addAttribute("errorMessage", errorMsg);
            return "login-form";
        }
        return "redirect:/nets/net-list";
    }

}

