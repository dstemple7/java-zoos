package com.lambdaschool.zoo.repositories;

import com.lambdaschool.zoo.models.Animal;
import com.lambdaschool.zoo.models.Zooanimal;
import com.lambdaschool.zoo.views.AnimalCounts;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AnimalRepository extends CrudRepository<Animal, Long>
{
    @Query(value = "SELECT a.ANIMALID, ANIMALTYPE, count(ZOOID) as countzoos " +
        "FROM ANIMAL a LEFT JOIN ZOOANIMALS z " +
        "ON a.ANIMALID = z.ANIMALID " +
        "GROUP BY a.animalid", nativeQuery = true)
    List<AnimalCounts> findAnimalCounts();
}
