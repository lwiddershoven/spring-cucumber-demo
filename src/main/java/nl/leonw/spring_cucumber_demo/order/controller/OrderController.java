package nl.leonw.spring_cucumber_demo.order.controller;

import nl.leonw.spring_cucumber_demo.order.api.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.toMap;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final Map<String, Order> database = Set.of("example")
            .stream()
            .collect(toMap(id -> id, id -> new Order(id, false)));

    @GetMapping("/")
    public Set<Order> getAllOrders() {
        return Set.copyOf(database.values());
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable("id") String id) {
        // Exception to status code mapping is documented in: https://docs.spring.io/spring-framework/docs/3.2.x/spring-framework-reference/html/mvc.html#mvc-ann-rest-spring-mvc-exceptions
        // You can of course always add your own exception handlers; these are just the defaults.
        var order = database.get(id);
        if (order == null) {
            throw new ResourceNotFoundException();
        }
        return order;
    }

}
