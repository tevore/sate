package com.sate.entities.repositories;

import com.sate.entities.Restaurant;
import io.micronaut.context.annotation.Primary;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import javax.inject.Singleton;

@Repository
//@Singleton
//@Primary
public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
}
