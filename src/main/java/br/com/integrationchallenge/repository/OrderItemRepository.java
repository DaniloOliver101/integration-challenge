package br.com.integrationchallenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItem extends JpaRepository<OrderItem, Long> {
}