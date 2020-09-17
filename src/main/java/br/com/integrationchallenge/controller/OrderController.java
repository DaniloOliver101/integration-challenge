package br.com.integrationchallenge.controller;

import br.com.integrationchallenge.controller.dto.CustomerDto;
import br.com.integrationchallenge.controller.dto.OrderDto;
import br.com.integrationchallenge.controller.form.CustomerForm;
import br.com.integrationchallenge.controller.form.OrderForm;
import br.com.integrationchallenge.model.Customer;
import br.com.integrationchallenge.model.Order;
import br.com.integrationchallenge.repository.CustomerRepository;
import br.com.integrationchallenge.repository.OrderItemRepository;
import br.com.integrationchallenge.repository.OrderRepository;
import br.com.integrationchallenge.repository.PaymentDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private PaymentDetailRepository paymentDetailRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping
    public List<OrderDto> listOrders(Long orderId) {
        if (orderId == null) {
            List<Order> orders = orderRepository.findAll();
            return OrderDto.convert(orders);
        } else {
            List<Order> orders = orders = orderRepository.findByOrderId(orderId);
            return OrderDto.convert(orders);
        }
    }

    @PostMapping
    public ResponseEntity<OrderDto> createOrder(@RequestBody OrderForm form, UriComponentsBuilder uriBuilder) {
        Order order = form.convert(customerRepository);
        orderRepository.save(order);
        form.getItems().forEach(item -> {
            item.convert(orderRepository);
        });
        URI uri = uriBuilder.path("/order/{id}").buildAndExpand(order.getId()).toUri();
        return ResponseEntity.created(uri).body(new OrderDto(order));
    }
}