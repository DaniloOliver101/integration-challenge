package br.com.integrationchallenge.controller.dto;

import br.com.integrationchallenge.model.PaymentDetails;

import java.util.List;
import java.util.stream.Collectors;

public class PaymentDto {
    private String creditCardNumber;
    private String creditCardOwner;
    private String cvvNumber;
    private String validateDate;

    public PaymentDto(PaymentDetails paymentDetails){
        this.creditCardOwner = paymentDetails.getCreditCardOwner();
                this.creditCardNumber = paymentDetails.getCreditCardNumber();
        this.cvvNumber = paymentDetails.getCvvNumber();
        this.validateDate = paymentDetails.getValidateDate();
    }

    public List<PaymentDto> convert(List<PaymentDetails> paymentDetailsList){
        return paymentDetailsList.stream().map(PaymentDto::new).collect(Collectors.toList());
    }
}
