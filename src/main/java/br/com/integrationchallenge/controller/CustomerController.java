package br.com.integrationchallenge.controller;

import br.com.integrationchallenge.controller.dto.OrderDto;
import br.com.integrationchallenge.model.Order;
import br.com.integrationchallenge.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;
    @RequestMapping("/order")
    public List<Order> orderService(Long orderId){

        List<Order> orders = orders = orderRepository.findAll();

        return orders;

    }
}