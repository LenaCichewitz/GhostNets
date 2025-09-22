package com.ipwa02.ghost_nets.Controller;

import com.ipwa02.ghost_nets.Model.Net;
import com.ipwa02.ghost_nets.Model.User;
import com.ipwa02.ghost_nets.Service.NetService;
import com.ipwa02.ghost_nets.Statuses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/nets")
public class NetController {

    @Autowired
    private NetService netService;

    @GetMapping("/net-form")
    public String showAddNetForm(Model model) {
        model.addAttribute("net", new Net());
        return "net-form";
    }
    @PostMapping("/update")
    public String updateNet(@ModelAttribute Net net) {
        netService.updateNet(net);
        return "redirect:/nets/net-list";
    }
    @GetMapping("/edit/{id}")
    public String showEditNetForm(@PathVariable("id") int id,Model model) {
        Net net = netService.getNetById(id);
        model.addAttribute("net", net);
        return "edit-net-form";
    }

    @GetMapping("/net-rescue/{id}")
    public String setNetBerger(@PathVariable("id") int id) {
        Net net = netService.getNetById(id);
        // model.addAttribute("net", net);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        netService.setBergerForNet(user, net);
        net.setStatus(Statuses.RECOVERY_PENDING);
        netService.updateNet(net);
        return "redirect:/nets/net-list";
    }
    @GetMapping("/net-recovered/{id}")
    public String setNetRecovered(@PathVariable("id") int id) {
        Net net = netService.getNetById(id);
        net.setStatus(Statuses.RECOVERED);
        netService.updateNet(net);
        return "redirect:/nets/net-list";
    }
    @GetMapping("/net-lost/{id}")
    public String setNetLost(@PathVariable("id") int id) {
        Net net = netService.getNetById(id);
        net.setStatus(Statuses.LOST);
        netService.updateNet(net);
        return "redirect:/nets/net-list";
    }
    @PostMapping("/add-net")
    public String addNet(@ModelAttribute Net net) {
        int netId = netService.saveNet(net);
        System.out.println("netId: " + netId);
        System.out.println("latitude " + net.getLatitude());
        System.out.println("longtitude " + net.getLongitude());
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        boolean loggedIn =auth != null && auth.isAuthenticated() && !(auth instanceof AnonymousAuthenticationToken);
        System.out.println("User logged in: " + loggedIn);
        if (loggedIn) {
            return "redirect:/nets/net-list";
        } else {
            return "redirect:/users/show-contact-form/" + netId;
        }
    }

    @GetMapping("/net-list")
    public String getAllNets(Model model) {
        List<Net> nets = netService.getAllNets();
        model.addAttribute("nets", nets);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        boolean loggedIn =auth != null && auth.isAuthenticated() && !(auth instanceof AnonymousAuthenticationToken);
        model.addAttribute("loggedIn", loggedIn);
        if (loggedIn) {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            model.addAttribute("user", user);
        }
        return "net-list";
    }
}