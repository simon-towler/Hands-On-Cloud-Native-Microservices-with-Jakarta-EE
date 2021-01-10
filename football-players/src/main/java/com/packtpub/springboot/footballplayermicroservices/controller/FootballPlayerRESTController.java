package com.packtpub.springboot.footballplayermicroservices.controller;

import com.packtpub.springboot.footballplayermicroservices.model.FootballPlayer;
import com.packtpub.springboot.footballplayermicroservices.service.FootballPlayerService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/footballplayer")
public class FootballPlayerRESTController {

    @Autowired
    private FootballPlayerService service;
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Simon says uccessfully retrieved list"),
        @ApiResponse(responseCode = "404", description = "Simon says the resource you were trying to reach is not found") })
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public Iterable<FootballPlayer> findAll() {
        return service.findAll();
    }

    @ApiOperation(value = "Simon says add a football player")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = "application/json")
    public FootballPlayer save(@RequestBody FootballPlayer entity) {
        return service.save(entity);
    }

    @ApiOperation(value = "Simon says update a football player")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = "application/json")
    public FootballPlayer edit(@PathVariable Integer id, @RequestBody FootballPlayer entity) {
        return service.save(entity);
    }

    @ApiOperation(value = "Simon says delete a football player")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public void delete(@PathVariable Integer id) {
        service.deleteById(id);
    }

    @ApiOperation(value = "Simon says search for a football player by ID")
    @RequestMapping(value = "/show/{id}", method = RequestMethod.GET, produces = "application/jsonx")
    public Optional<FootballPlayer> findById(@PathVariable Integer id) {
        return service.findById(id);
    }
}
