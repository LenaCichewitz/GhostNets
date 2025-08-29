package com.ipwa02.ghost_nets.Repository;

import com.ipwa02.ghost_nets.Model.Contact;
import com.ipwa02.ghost_nets.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {}