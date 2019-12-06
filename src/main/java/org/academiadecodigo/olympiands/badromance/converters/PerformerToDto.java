package org.academiadecodigo.olympiands.badromance.converters;

import org.academiadecodigo.olympiands.badromance.command.PerformerDto;
import org.academiadecodigo.olympiands.badromance.persistence.model.user.Performer;
import org.springframework.stereotype.Component;

@Component
public class PerformerToDto extends AbstractConverter<Performer, PerformerDto> {


    @Override
    public PerformerDto convert(Performer performer) {

        PerformerDto performerDto = new PerformerDto();
        performerDto.setId(performer.getId());
        performerDto.setEmail(performer.getEmail());
        performerDto.setName(performer.getName());
        performerDto.setPhone(performer.getPhone());

        return performerDto;
    }
}
