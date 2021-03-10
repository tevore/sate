package com.sate.entities.repositories;

import io.micronaut.context.BeanContext;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.model.Pageable;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
class RestaurantRepositoryTest {

    @Inject
    BeanContext beanContext;

    @Test
    void findByNameLike() {

        String query = beanContext.getBeanDefinition(RestaurantRepository.class)
                .getRequiredMethod("findByNameLike", String.class, Pageable.class)
                .getAnnotationMetadata().stringValue(Query.class)
                .orElse(null);

        assertEquals(
                "SELECT restaurant_ FROM com.sate.entities.Restaurant AS restaurant_ WHERE (restaurant_.name like :p1)", query);

    }
}