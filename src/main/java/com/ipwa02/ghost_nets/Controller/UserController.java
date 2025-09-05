package com.ipwa02.ghost_nets.Controller;

import com.ipwa02.ghost_nets.Model.Contact;
import com.ipwa02.ghost_nets.Model.Net;
import com.ipwa02.ghost_nets.Model.User;
import com.ipwa02.ghost_nets.Service.ContactService;
import com.ipwa02.ghost_nets.Service.NetService;
import com.ipwa02.ghost_nets.Service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    ContactService contactService;
    @Autowired
    private NetService netService;

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "login-form";
    }
    @GetMapping("/show-contact-form/{netId}")
    public String showContactForm(@PathVariable("netId") int netId, Model model) {
        Net net = netService.getNetById(netId);
        System.out.println("net Id for new contact" + netId);
        model.addAttribute("net", net);
        model.addAttribute("contact", new Contact());
        return "contact-form";
    }
    @PostMapping("/add-contact")
    public String addContact(@ModelAttribute Contact contact, @RequestParam int netId) {
        contactService.addContact(contact);
        Net net = netService.getNetById(netId);
        System.out.println("add contact für netz nr " + net.getId());
        netService.addContactToNet(contact, net);
        return "redirect:/nets/net-list";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        SecurityContextHolder.clearContext();
        session.invalidate();
        return "redirect:/login-form";
    }

}

