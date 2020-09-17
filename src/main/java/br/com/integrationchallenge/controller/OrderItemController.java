package br.com.integrationchallenge.controller;

import br.com.integrationchallenge.controller.dto.OrderDto;
import br.com.integrationchallenge.controller.dto.OrderItemDto;
import br.com.integrationchallenge.controller.form.OrderForm;
import br.com.integrationchallenge.controller.form.OrderItemForm;
import br.com.integrationchallenge.model.Order;
import br.com.integrationchallenge.model.OrderItem;
import br.com.integrationchallenge.repository.CustomerRepository;
import br.com.integrationchallenge.repository.OrderItemRepository;
import br.com.integrationchallenge.repository.OrderRepository;
import br.com.integrationchallenge.repository.PaymentDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/order/item")
public class OrderItemController {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private PaymentDetailRepository paymentDetailRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping
    public List<OrderItemDto> listItems(Long orderItemId) {
        if (orderItemId == null) {
            List<OrderItem> items = orderItemRepository.findAll();
            return OrderItemDto.convert(items);
        } else {
            List<OrderItem> items = orderItemRepository.findByOrderItemId(orderItemId);
            return OrderItemDto.convert(items);
        }
    }

    @PostMapping
    public ResponseEntity<OrderItemDto> createOrder(@RequestBody OrderItemForm form, UriComponentsBuilder uriBuilder) {
        OrderItem orderItem = form.convert(orderRepository);

        orderItemRepository.save(orderItem);
        URI uri = uriBuilder.path("/order/item/{id}").buildAndExpand(orderItem.getId()).toUri();

        return ResponseEntity.created(uri).body(new OrderItemDto(orderItem));
    }
}