package org.academiadecodigo.olympiands.badromance.converters;

import org.academiadecodigo.olympiands.badromance.command.CustomerDto;
import org.academiadecodigo.olympiands.badromance.persistence.model.user.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerToDto extends AbstractConverter<Customer, CustomerDto> {

    @Override
    public CustomerDto convert(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customer.getId());
        customerDto.setFirstName(customer.getFirstName());
        customerDto.setLastName(customer.getLastName());
        customerDto.setEmail(customer.getEmail());
        customerDto.setPhone(customer.getPhone());

        return customerDto;
    }
}
