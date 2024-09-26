package nl.leonw.spring_cucumber_demo.order.controller;

import nl.leonw.spring_cucumber_demo.order.api.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @GetMapping("/")
    public Set<Order> getAllOrders() {
        return Set.of(new Order("example", false));
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable("id") String id) {
        return new Order(id, false);
    }

}
