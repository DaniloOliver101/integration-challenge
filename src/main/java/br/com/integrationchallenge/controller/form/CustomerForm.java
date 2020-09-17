package br.com.integrationchallenge.controller.form;

import br.com.integrationchallenge.model.Customer;

public class CustomerForm {
    private String name;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public CustomerForm(String name, String email){
        this.name = name;
        this.email = email;
    }

    public Customer convert() {
        return new Customer(name, email);

    }
}
