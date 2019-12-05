package org.academiadecodigo.olympiands.badromance.converters;

import org.academiadecodigo.olympiands.badromance.command.RequestDto;
import org.academiadecodigo.olympiands.badromance.persistence.model.Request;
import org.springframework.stereotype.Component;

@Component
public class RequestToDto extends AbstractConverter<Request, RequestDto> {


    @Override
    public RequestDto convert(Request request) {

        RequestDto requestDto = new RequestDto();
        requestDto.setId(request.getId());
        requestDto.setAddress(request.getAddress());
        requestDto.setGenre(request.getGenre());
        requestDto.setComments(request.getComments());
        requestDto.setScheduledTime(request.getScheduledTime());
        requestDto.setTargetName(request.getTargetName());

        return requestDto;
    }
}
