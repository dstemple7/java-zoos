package com.lambdaschool.zoo.controllers;

import com.lambdaschool.zoo.models.Zoo;
import com.lambdaschool.zoo.services.ZooService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/zoos")
public class ZooController
{
    @Autowired
    private ZooService zooservice;

    // http://localhost:2019/zoos/zoos
    @GetMapping(value = "/zoos", produces = "application/json")
    public ResponseEntity<?> getZoos()
    {
        List<Zoo> myList = zooservice.getZoos();
        return new ResponseEntity<>(myList, HttpStatus.OK);
    }

    // http://localhost:2019/zoos/zoo/5
    @GetMapping(value = "/zoo/{id}", produces = "application/json")
    public ResponseEntity<?> getZooById(@PathVariable long id)
    {
        Zoo myZoo = zooservice.getZooById(id);
        return new ResponseEntity<>(myZoo, HttpStatus.OK);
    }

}
