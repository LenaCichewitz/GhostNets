package com.ipwa02.ghost_nets.Controller;

import com.ipwa02.ghost_nets.Model.Net;
import com.ipwa02.ghost_nets.Service.NetService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @PostMapping("/upd-net-form")
    public String showUpdNetForm(@ModelAttribute Net net,Model model) {

        model.addAttribute("net", net);
        return "net-form";
    }
    @PostMapping("/add-net")
    public String addNet(@ModelAttribute Net net) {
        netService.saveNet(net);
        return "redirect:/users/show-contact-form";
        // return "redirect:/nets/net-list";
    }

    @GetMapping("/net-list")
    public String getAllNets(Model model) {
        List<Net> nets = netService.getAllNets();
        model.addAttribute("nets", nets);
        return "net-list";
    }
}