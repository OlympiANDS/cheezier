package org.academiadecodigo.olympiands.badromance.converters;

import org.academiadecodigo.olympiands.badromance.command.RequestDto;
import org.academiadecodigo.olympiands.badromance.persistence.model.Request;
import org.academiadecodigo.olympiands.badromance.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DtoToRequest implements Converter<RequestDto, Request> {

    private RequestService requestService;

    @Autowired
    public void setRequestService(RequestService requestService) {
        this.requestService = requestService;
    }


    @Override
    public Request convert(RequestDto requestDto) {

        Request request = (requestDto.getId()) != null ? requestService.get(requestDto.getId()) : new Request();

        request.setComments(requestDto.getComments());
        request.setAddress(requestDto.getAddress());
        request.setGenre(requestDto.getGenre());
        request.setScheduledTime(requestDto.getScheduledTime());
        request.setTargetName(requestDto.getTargetName());

        return request;
    }
}
