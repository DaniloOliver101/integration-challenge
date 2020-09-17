package br.com.integrationchallenge.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "payment_details", schema = "integration")
public class PaymentDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String creditCardOwner;
    private String creditCardNumber;
    private String cvvNumber;

    public void setCreditCardOwner(String creditCardOwner) {
        this.creditCardOwner = creditCardOwner;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public void setCvvNumber(String cvvNumber) {
        this.cvvNumber = cvvNumber;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setValidateDate(String validateDate) {
        this.validateDate = validateDate;
    }

    @ManyToOne
    @JoinColumn
    private Order order;
    private String validateDate;

    public long getId() {
        return id;
    }

    public String getCreditCardOwner() {
        return creditCardOwner;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public String getCvvNumber() {
        return cvvNumber;
    }

    public Order getOrder() {
        return order;
    }

    public String getValidateDate() {
        return validateDate;
    }
}
