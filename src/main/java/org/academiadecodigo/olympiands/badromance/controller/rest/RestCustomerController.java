package org.academiadecodigo.olympiands.badromance.controller.rest;

import org.academiadecodigo.olympiands.badromance.command.CustomerDto;
import org.academiadecodigo.olympiands.badromance.converters.CustomerToDto;
import org.academiadecodigo.olympiands.badromance.converters.DtoToCustomer;
import org.academiadecodigo.olympiands.badromance.exceptions.AssociationExistsException;
import org.academiadecodigo.olympiands.badromance.exceptions.CustomerNotFoundException;
import org.academiadecodigo.olympiands.badromance.persistence.model.user.Customer;
import org.academiadecodigo.olympiands.badromance.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/customer")
public class RestCustomerController {

    private CustomerService customerService;
    private CustomerToDto customerToDto;
    private DtoToCustomer dtoToCustomer;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Autowired
    public void setCustomerToDto(CustomerToDto customerToDto) {
        this.customerToDto = customerToDto;
    }

    @Autowired
    public void setDtoToCustomer(DtoToCustomer dtoToCustomer) {
        this.dtoToCustomer = dtoToCustomer;
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/login"})
    public ResponseEntity<CustomerDto> getCustomerByEmail(String email){
        Customer customer = customerService.get(email);

        if (customer == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(customerToDto.convert(customer), HttpStatus.OK);

    }
    @RequestMapping(method = RequestMethod.GET, path = {"/", ""})
    public ResponseEntity<List<CustomerDto>> listCustomers(){
        List<CustomerDto> customerDtos = new ArrayList<>();

        for (Customer customer: customerService.list()){
            customerDtos.add(customerToDto.convert(customer));
        }

        return new ResponseEntity<>(customerDtos, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "{id}")
    public ResponseEntity<CustomerDto> showCustomer(@PathVariable Integer id){
        Customer customer = customerService.get(id);

        if (customer == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(customerToDto.convert(customer), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = {"/", ""})
    public ResponseEntity<?> addCustomer(@Valid @RequestBody CustomerDto customerDto, BindingResult bindingResult, UriComponentsBuilder uriComponentsBuilder){

        if (bindingResult.hasErrors() || customerDto.getId() != null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Customer savedCustomer = customerService.save(dtoToCustomer.convert(customerDto));

        UriComponents uriComponents = uriComponentsBuilder.path("/api/customer/" + savedCustomer.getId()).build();

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponents.toUri());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public ResponseEntity<CustomerDto> editCustomer(@Valid @RequestBody CustomerDto customerDto, BindingResult bindingResult, @PathVariable Integer id){

        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (customerDto.getId() != null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (customerService.get(id) == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        customerDto.setId(id);

        customerService.save(dtoToCustomer.convert(customerDto));
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public ResponseEntity<CustomerDto> deleteCustomer(@PathVariable Integer id){

        try {
            customerService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } catch (AssociationExistsException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        } catch (CustomerNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
