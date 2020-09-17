package br.com.integrationchallenge.repository;

import br.com.integrationchallenge.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    @Query("select item FROM OrderItem item where item.id = :orderItemId")
    List<OrderItem> findByOrderItemId(@Param("orderItemId") Long orderItemId);
}