package org.academiadecodigo.olympiands.badromance.controller.rest;

import org.academiadecodigo.olympiands.badromance.command.RequestDto;
import org.academiadecodigo.olympiands.badromance.converters.DtoToRequest;
import org.academiadecodigo.olympiands.badromance.converters.RequestToDto;
import org.academiadecodigo.olympiands.badromance.exceptions.CustomerNotFoundException;
import org.academiadecodigo.olympiands.badromance.exceptions.RequestNotFoundException;
import org.academiadecodigo.olympiands.badromance.persistence.model.Request;
import org.academiadecodigo.olympiands.badromance.service.CustomerService;
import org.academiadecodigo.olympiands.badromance.service.RequestService;
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
public class RestRequestController {

    private CustomerService customerService;
    private RequestService requestService;
    private DtoToRequest dtoToRequest;
    private RequestToDto requestToDto;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Autowired
    public void setRequestService(RequestService requestService) {
        this.requestService = requestService;
    }

    @Autowired
    public void setRequestToDto(RequestToDto requestToDto) {
        this.requestToDto = requestToDto;
    }

    @Autowired
    public void setDtoToRequest(DtoToRequest dtoToRequest) {
        this.dtoToRequest = dtoToRequest;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}/request")
    public ResponseEntity<List<RequestDto>> listRequests(@PathVariable Integer id){
        try {
            List<Request> requests = customerService.listRequests(id);
            List<RequestDto> requestDtos = new ArrayList<>();

            for (Request request : requests){
                requestDtos.add(requestToDto.convert(request));
            }

            return new ResponseEntity<>(requestDtos, HttpStatus.OK);
        }catch (CustomerNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @RequestMapping(method = RequestMethod.GET, path = "/{cid}/request/{id}")
    public ResponseEntity<RequestDto> showRequest(@PathVariable Integer cid, @PathVariable Integer id){

        Request request = requestService.get(id);

        if (request == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(requestToDto.convert(request), HttpStatus.OK);
    }



    @RequestMapping(method = RequestMethod.POST, path = "{id}/request")
    public ResponseEntity<?> addRequest(@PathVariable Integer id, @Valid @RequestBody RequestDto requestDto, BindingResult bindingResult, UriComponentsBuilder uriComponentsBuilder){

        if (bindingResult.hasErrors() || requestDto.getId() != null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            Request request = customerService.addRequest(id, dtoToRequest.convert(requestDto));

            UriComponents uriComponents = uriComponentsBuilder.path("api/customer/"+id+"/request"+request.getId()).build();
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(uriComponents.toUri());

            return new ResponseEntity<>(headers, HttpStatus.CREATED);

        }catch (CustomerNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (RequestNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.PUT, path = "{cid}/request/{id}")
    public ResponseEntity<RequestDto> editRequest(@PathVariable Integer cid, @PathVariable Integer id, @Valid @RequestBody RequestDto requestDto, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (requestDto.getId() != null && requestDto.getId() != id){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        requestDto.setId(id);

        Request savedRequest = dtoToRequest.convert(requestDto);
        customerService.completeRequest(cid, savedRequest.getId());

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
