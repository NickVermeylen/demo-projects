package com.nckvrmyln.producer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderCreationTest {

    @Test
    public void orderCreationTest() {

        Order order = new Order("1F3A", "Sheldon", "Cooper");
        Assertions.assertEquals(order.getId(), "1F3A");
        Assertions.assertEquals(order.getFirstName(), "Sheldon");
        Assertions.assertEquals(order.getLastName(), "Cooper");
    }
}
