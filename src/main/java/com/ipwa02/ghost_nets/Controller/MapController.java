package com.ipwa02.ghost_nets.Controller;
import com.ipwa02.ghost_nets.Model.Net;
import com.ipwa02.ghost_nets.Service.NetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class MapController {

    @Autowired
    private NetService netService;

    @Value("${tomtom.apikey}")
    private String tomTomApiKey;

    @GetMapping("/")
    public String homePage(Model model) {
        List<Net> nets = netService.getAllNets();
        model.addAttribute("apikey", tomTomApiKey);
        model.addAttribute("nets",nets );
        return "home";
    }

}