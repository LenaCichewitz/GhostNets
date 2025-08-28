package com.ipwa02.ghost_nets.Service;

import com.ipwa02.ghost_nets.Model.Net;
import com.ipwa02.ghost_nets.Repository.NetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NetService {

    @Autowired
    private NetRepository netRepository;

    public List<Net> getAllNets() {
        return netRepository.findAll();
    }

    public void saveNet(Net net) {
        netRepository.save(net);
    }
}
