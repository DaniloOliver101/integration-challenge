package br.com.integrationchallenge.controller.form;

import br.com.integrationchallenge.model.Order;
import br.com.integrationchallenge.model.OrderItem;
import br.com.integrationchallenge.repository.OrderRepository;
import java.math.BigDecimal;

public class OrderItemForm {
    private Double price;
    private long orderId;
    private String item;

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    public OrderItem convert(OrderRepository orderRepository) {
        Order order = orderRepository.findOrderById(orderId);
        return new OrderItem(item, BigDecimal.valueOf(price), order);
    }
}
