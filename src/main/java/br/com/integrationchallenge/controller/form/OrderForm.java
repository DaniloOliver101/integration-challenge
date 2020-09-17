package br.com.integrationchallenge.controller.form;

import br.com.integrationchallenge.controller.dto.OrderItemDto;
import br.com.integrationchallenge.controller.dto.PaymentDto;
import br.com.integrationchallenge.model.Customer;
import br.com.integrationchallenge.model.Order;
import br.com.integrationchallenge.model.OrderItem;
import br.com.integrationchallenge.model.PaymentDetails;
import br.com.integrationchallenge.repository.CustomerRepository;
import br.com.integrationchallenge.repository.OrderItemRepository;
import br.com.integrationchallenge.repository.PaymentDetailRepository;

import java.math.BigDecimal;
import java.util.List;

public class OrderForm {
    private long customerId;
    private Double value;
    private List<OrderItemForm> items;

    public List<OrderItemForm> getItems() {
        return items;
    }

    public void setItems(List<OrderItemForm> items) {
        this.items = items;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Order convert(CustomerRepository customerRepository, PaymentDetailRepository paymentDetailRepository, OrderItemRepository orderItemRepository) {
        Customer customer = customerRepository.findCustomerById(customerId);
        List<PaymentDetails> payments = paymentDetailRepository.findAll();
        List<OrderItem> orderItems = null;

        return new Order(customer, orderItems, payments, BigDecimal.valueOf(value));
    }


    public Order convert(CustomerRepository customerRepository) {
        Customer customer = customerRepository.findCustomerById(customerId);
        return new Order(customer, value);
    }
}
