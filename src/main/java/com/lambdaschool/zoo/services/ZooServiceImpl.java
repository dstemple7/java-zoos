package com.lambdaschool.zoo.services;


import com.lambdaschool.zoo.models.Zoo;
import com.lambdaschool.zoo.repositories.ZooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service(value = "zooService")
public class ZooServiceImpl implements ZooService
{
    @Autowired
    private ZooRepository zooRepository;
    @Override
    public List<Zoo> getZoos()
    {
        List<Zoo> myList = new ArrayList<>();
        zooRepository.findAll().iterator().forEachRemaining(myList::add);
        return myList;
    }

    @Override
    public Zoo getZooById(long id)
    {
        Zoo myZoo = zooRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Zoo " + id + " Not Found"));
        return myZoo;
    }
}
