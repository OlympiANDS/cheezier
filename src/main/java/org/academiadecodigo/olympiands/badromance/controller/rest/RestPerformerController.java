package org.academiadecodigo.olympiands.badromance.controller.rest;

import org.academiadecodigo.olympiands.badromance.command.PerformerDto;
import org.academiadecodigo.olympiands.badromance.converters.DtoToPerformer;
import org.academiadecodigo.olympiands.badromance.converters.PerformerToDto;
import org.academiadecodigo.olympiands.badromance.persistence.model.user.Performer;
import org.academiadecodigo.olympiands.badromance.service.PerformerService;
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
@RequestMapping("api/performer")
public class RestPerformerController {

    private PerformerService performerService;
    private PerformerToDto performerToDto;
    private DtoToPerformer dtoToPerformer;

    @Autowired
    public void setPerformerService(PerformerService performerService) {
        this.performerService = performerService;
    }

    @Autowired
    public void setPerformerToDto(PerformerToDto performerToDto) {
        this.performerToDto = performerToDto;
    }

    @Autowired
    public void setDtoToPerformer(DtoToPerformer dtoToPerformer) {
        this.dtoToPerformer = dtoToPerformer;
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/", ""})
    public ResponseEntity<List<PerformerDto>> listPerformers(){
        List<PerformerDto> performerDtos = new ArrayList<>();

        for (Performer performer: performerService.list()){
            performerDtos.add(performerToDto.convert(performer));
        }

        return new ResponseEntity<>(performerDtos, HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.GET, path="{id}")
    public ResponseEntity<PerformerDto> showPerformer(@PathVariable Integer id){
        Performer performer = performerService.get(id);

        if (performer == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(performerToDto.convert(performer), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = {"/", ""})
    public ResponseEntity<?> addPerformer(@Valid @RequestBody PerformerDto performerDto, BindingResult bindingResult, UriComponentsBuilder uriComponentsBuilder){

        if (bindingResult.hasErrors() || performerDto.getId() != null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Performer savedPerformer = performerService.save(dtoToPerformer.convert(performerDto));

        UriComponents uriComponents = uriComponentsBuilder.path("/api/performer/"+savedPerformer.getId()).build();

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponents.toUri());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }


}
