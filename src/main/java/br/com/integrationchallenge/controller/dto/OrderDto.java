package br.com.integrationchallenge.controller.dto;

import br.com.integrationchallenge.controller.form.OrderForm;
import br.com.integrationchallenge.model.Customer;
import br.com.integrationchallenge.model.Order;
import br.com.integrationchallenge.model.OrderItem;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class OrderDto {
    private long orderId;
    private long customerId;
    //    private List<OrderItemDto> items;
    private BigDecimal value;
    public OrderDto(Order order){
        this.orderId = order.getId();
        this.value = order.getValue();
        this.customerId = order.getCustomer().getId();
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public static List<OrderDto> convert(List<Order> orders) {
        return orders.stream().map(OrderDto::new).collect(Collectors.toList());
    }
}
