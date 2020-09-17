package br.com.integrationchallenge.repository;

import br.com.integrationchallenge.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("SELECT c FROM Customer c WHERE c.id = :customerId")
    List<Customer> getAllByCustomerId(@Param("customerId") long customerId);
    Customer findCustomerById(long customerId);
}
