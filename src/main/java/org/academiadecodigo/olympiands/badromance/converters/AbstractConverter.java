package org.academiadecodigo.olympiands.badromance.converters;

import org.springframework.core.convert.converter.Converter;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractConverter<S, T> implements Converter<S, T> {

    public List<T> convert(List<S> listToConvert){
        List<T> conversions = new ArrayList<>(listToConvert.size());

        for (S toConvert : listToConvert){
            conversions.add(convert(toConvert));
        }

        return conversions;
    }
}
