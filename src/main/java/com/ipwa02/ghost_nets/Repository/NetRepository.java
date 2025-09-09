package com.ipwa02.ghost_nets.Repository;

import com.ipwa02.ghost_nets.Model.Net;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NetRepository extends JpaRepository<Net, Integer> {
    @Override
    Optional<Net> findById(Integer integer);

    List<Net> findAllByBergerId(int id);
}
