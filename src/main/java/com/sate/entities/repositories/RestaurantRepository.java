package com.sate.entities.repositories;

import com.sate.entities.Restaurant;
import io.micronaut.context.annotation.Executable;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import io.micronaut.data.repository.CrudRepository;


@Repository
public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {

    @Executable
    Page<Restaurant> findByNameLike(String name, Pageable pageable);
}
