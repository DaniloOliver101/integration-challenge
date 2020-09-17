package br.com.integrationchallenge.repository;

import br.com.integrationchallenge.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("SELECT o FROM Order o where o.id = :orderId")
    List<Order> findByOrderId(@Param("orderId") long orderId);

    Order findOrderById(long orderId);

}