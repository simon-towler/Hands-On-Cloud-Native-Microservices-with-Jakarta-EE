package com.packtpub.springboot.footballplayermicroservices.service;

import com.packtpub.springboot.footballplayermicroservices.model.FootballPlayer;
import com.packtpub.springboot.footballplayermicroservices.repository.FootballPlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FootballPlayerService {

    @Autowired
    private FootballPlayerRepository repository;

    /*
    The repository extends CRUDRepository, so we can call some CRUD methods on it from here
     */

    public Iterable<FootballPlayer> findAll() {
        return repository.findAll();
    }

    public FootballPlayer save(FootballPlayer entity) {
        return repository.save(entity);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public Optional<FootballPlayer> findById(Integer id) {
        return repository.findById(id);
    }
}
