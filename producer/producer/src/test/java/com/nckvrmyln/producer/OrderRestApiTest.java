package com.nckvrmyln.producer;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;

@WebFluxTest
@Import(OrderHttpRouterConfiguration.class)
public class OrderRestApiTest {

    @MockBean
    private OrderRepository orderRepository;

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void getAllOrders(){

        Mockito.when(this.orderRepository.findAll())
                .thenReturn(Flux.just(new Order("1F3A", "Sheldon", "Cooper")));


        this.webTestClient
                .get()
                .uri("http://localhost:8080/orders")
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody()
                .json("{id: \"1F3A\", firstName: \"Sheldon\", lastName: \"Cooper\"}");
    }

}
