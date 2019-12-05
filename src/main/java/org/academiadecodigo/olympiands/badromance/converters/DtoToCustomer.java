package org.academiadecodigo.olympiands.badromance.converters;


import org.academiadecodigo.olympiands.badromance.command.CustomerDto;
import org.academiadecodigo.olympiands.badromance.persistence.model.user.Customer;
import org.academiadecodigo.olympiands.badromance.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DtoToCustomer implements Converter<CustomerDto, Customer> {

    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public Customer convert(CustomerDto customerDto) {

        Customer customer = (customerDto.getId()) != null ? customerService.get(customerDto.getId()) : new Customer();

        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setEmail(customerDto.getEmail());
        customer.setPhone(customerDto.getPhone());

        return customer;
    }
}
