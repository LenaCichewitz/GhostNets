package com.ipwa02.ghost_nets.Service;

import com.ipwa02.ghost_nets.Model.Contact;
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

    public int saveNet(Net net) {
       Net savedNet =   netRepository.save(net);
       return savedNet.getId();
    }

    public Net getNetById(int id) {
        return netRepository.findById(id).isPresent() ?  netRepository.findById(id).get() : null;
    }

    public void updateNet(Net net) {
        netRepository.save(net);
    }
    public void addContactToNet(Contact contact, Net net) {
        net.setContactId(contact.getId());
        this.updateNet(net);
    }
}
