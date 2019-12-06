package org.academiadecodigo.olympiands.badromance.converters;

import org.academiadecodigo.olympiands.badromance.command.PerformerDto;
import org.academiadecodigo.olympiands.badromance.persistence.model.user.Performer;
import org.academiadecodigo.olympiands.badromance.service.PerformerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DtoToPerformer implements Converter<PerformerDto, Performer> {


    private PerformerService performerService;

    @Autowired
    public void setPerformerService(PerformerService performerService) {
        this.performerService = performerService;
    }

    @Override
    public Performer convert(PerformerDto performerDto) {

        Performer performer = (performerDto.getId()) != null ? performerService.get(performerDto.getId()) : new Performer();

        performer.setName(performerDto.getName());
        performer.setPhone(performerDto.getPhone());
        performer.setEmail(performerDto.getEmail());

        return performer;
    }
}
