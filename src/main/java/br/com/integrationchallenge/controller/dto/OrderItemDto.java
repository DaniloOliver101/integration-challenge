package br.com.integrationchallenge.controller.dto;

import br.com.integrationchallenge.model.OrderItem;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class OrderItemDto {
    private long orderId;
    private long orderItemId;
    private String item;
    private BigDecimal price;

    public OrderItemDto(OrderItem orderItem){
        this.orderItemId = orderItem.getId();
        this.price = orderItem.getPrice();
        this.item = orderItem.getName();
        this.orderId = orderItem.getOrder().getId();
    }

    public OrderItemDto() {

    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(long orderItemId) {
        this.orderItemId = orderItemId;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public static List<OrderItemDto> convert(List<OrderItem> items){
        return items.stream().map(OrderItemDto::new).collect(Collectors.toList());

    }
}
