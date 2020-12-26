package com.packtpub.springboot.footballplayermicroservices.controller;

import com.packtpub.springboot.footballplayermicroservices.model.FootballPlayer;
import com.packtpub.springboot.footballplayermicroservices.service.FootballPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/footballplayer")
public class FootballPlayerRESTController {

    @Autowired
    private FootballPlayerService service;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public Iterable<FootballPlayer> findAll() {
        return service.findAll();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = "application/json")
    public FootballPlayer save(@RequestBody FootballPlayer entity) {
        return service.save(entity);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = "application/json")
    public FootballPlayer edit(@PathVariable Integer id, @RequestBody FootballPlayer entity) {
        return service.save(entity);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public void delete(@PathVariable Integer id) {
        service.deleteById(id);
    }

    @RequestMapping(value = "/show/{id}", method = RequestMethod.GET, produces = "application/jsonx")
    public Optional<FootballPlayer> findById(@PathVariable Integer id) {
        return service.findById(id);
    }
}
