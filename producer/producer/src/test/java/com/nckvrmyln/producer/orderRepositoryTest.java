package com.nckvrmyln.producer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@DataR2dbcTest
public class orderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void findAll() {

        Flux<Order> order =
                orderRepository.deleteAll()
                        .thenMany(this.orderRepository.save(new Order(null, "Sheldon", "Cooper")))
                        .thenMany(this.orderRepository.findAll());

        StepVerifier.create(order)
                .expectNextMatches(record ->
                                record.getId().equalsIgnoreCase("1F3A") &&
                                record.getFirstName().equalsIgnoreCase("Sheldon") &&
                                record.getLastName().equalsIgnoreCase("Cooper"))
                .verifyComplete();
    }
}
