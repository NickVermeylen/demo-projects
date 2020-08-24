package com.nckvrmyln.producer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Configuration
public class OrderHttpRouterConfiguration {

    @Bean
    RouterFunction<ServerResponse> httpEndpoins(OrderRepository orderRepository) {
        return route()
                .GET("/reservations", r -> ok().body(orderRepository.findAll(), Order.class))
                .build();
    }
}
