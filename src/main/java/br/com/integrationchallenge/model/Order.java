package br.com.integrationchallenge.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
@Entity
@Table(name = "orders", schema = "integration")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime created = LocalDateTime.now();

    public Order(Customer customer, Double value) {

        this.value = BigDecimal.valueOf(value);
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", created=" + created +
                ", customer=" + customer +
                ", items=" + items +
                ", payments=" + payments +
                ", value=" + value +
                ", status='" + status + '\'' +
                '}';
    }

    public List<PaymentDetails> getPayments() {
        return payments;
    }

    @ManyToOne
    @JoinColumn(name = "ID_PGTO_LOTE")
    private Customer customer;
    @OneToMany(mappedBy = "order")
    private List<OrderItem> items;
    @OneToMany(mappedBy = "order")
    private List<PaymentDetails> payments;
    private BigDecimal value;
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
    private String status = "PENDING";

    public Order () {}

    public Order(Customer customer, List<OrderItem> items, List<PaymentDetails> payments, BigDecimal value) {
        this.customer = customer;
        this.payments = payments;
        this.items = items;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public BigDecimal getValue() {
        return value;
    }



    public String getStatus() {
        return status;
    }
}