package br.com.integrationchallenge.repository;

import br.com.integrationchallenge.model.PaymentDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentDetailRepository extends JpaRepository<PaymentDetails, Long> {
}