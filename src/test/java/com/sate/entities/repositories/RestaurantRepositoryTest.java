package com.sate.entities.repositories;

import com.sate.entities.Restaurant;
import io.micronaut.context.BeanContext;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;

import javax.inject.Inject;
import javax.persistence.EntityManager;


//@MicronautTest
class RestaurantRepositoryTest {

    @Inject
    private BeanContext beanContext;

    @Inject
    private RestaurantRepository restaurantRepository;

    @Inject
    private EntityManager entityManager;


//    @Test
    public void queryProducedShouldMatch() {

        String query = beanContext.getBeanDefinition(RestaurantRepository.class)
                .getRequiredMethod("findByNameLike", String.class, Pageable.class)
                .getAnnotationMetadata().stringValue(Query.class)
                .orElse(null);

//        assertEquals(
//                "SELECT restaurant_ FROM com.sate.entities.Restaurant AS restaurant_ WHERE (restaurant_.name like :p1)", query);

    }

//    @Test
    public void shouldSuccessfullyInsertData() {
        Restaurant fakeRestaurant = new Restaurant(
                "John's Place",
                "Japanese",
                "123 w pl",
                null,
                "city",
                "ST",
                "12345");
        Restaurant restaurant = restaurantRepository.save(fakeRestaurant);

//        assertNotNull(restaurant);
    }

//    @Test
    public void shouldFindSomeDataByName() {
        Restaurant fakeRestaurant = new Restaurant(
                "Rocking Burger",
                "American",
                "123 w pl",
                null,
                "city",
                "ST",
                "12345");

        entityManager.persist(fakeRestaurant);

        Page<Restaurant> pages = restaurantRepository.findByNameLike("%Rock%", Pageable.from(0, 3));

//        assertEquals(1, pages.getTotalPages());
    }
}