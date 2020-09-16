package br.com.integrationchallenge.repository;

import br.com.integrationchallenge.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Order extends JpaRepository<Order, Long> {
}