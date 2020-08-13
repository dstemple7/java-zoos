package com.lambdaschool.zoo.services;

import com.lambdaschool.zoo.models.Animal;
import com.lambdaschool.zoo.views.AnimalCounts;

import java.util.List;

public interface AnimalService
{
    List<AnimalCounts> count();
}
