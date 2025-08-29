package com.ipwa02.ghost_nets.Service;

import com.ipwa02.ghost_nets.Model.Contact;
import com.ipwa02.ghost_nets.Model.Net;
import com.ipwa02.ghost_nets.Repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;
    public void  addContact(Contact contact){contactRepository.save(contact);}
}
