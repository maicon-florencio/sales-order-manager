package com.microsservice.learning.produto.service.mapper;

import com.github.dozermapper.core.DozerBeanMapper;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Testando ferramenta dozer vs mapstruct com relacao a mapper
 */


public class DozerMapper {

    private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    public static <O,D> D parseOject( O origin,Class<D> destino) {
        return mapper.map(origin,destino);
    }

    public static <O,D> List<D> parseListOject(List<O> origin, Class<D> destino) {
        List<D> destinationObject = new ArrayList<D>();
        origin.forEach(o -> destinationObject.add(mapper.map(o, destino)));

        return destinationObject;
    }
}
