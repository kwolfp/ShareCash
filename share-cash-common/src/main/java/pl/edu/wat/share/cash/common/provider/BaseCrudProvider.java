package pl.edu.wat.share.cash.common.provider;

import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import pl.edu.wat.share.cash.common.dto.base.BaseDto;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Kamil Przyborowski
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018.
 */
public abstract class BaseCrudProvider<E extends Serializable, D extends BaseDto<?>> {

    @Autowired
    private MapperFacade mapperFacade;

    private Class<D> dtoClass;


    protected abstract E convert(D dto, E entity);

    protected D convert(E entity) {
        return mapperFacade.map(entity, getDtoClassFromGeneric());
    }

    protected List<D> convert(Collection<E> entities) {
        return entities.stream().map(this::convert).collect(Collectors.toCollection(ArrayList::new));
    }


    @SuppressWarnings("unchecked")
    private Class<D> getDtoClassFromGeneric() {
        if(dtoClass == null) {
            dtoClass = (Class<D>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        }
        return dtoClass;
    }

}
