package pl.edu.wat.share.cash.common.config;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.edu.wat.share.cash.common.mapper.Mapper;

/**
 * Created by Kamil Przyborowski
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018.
 */
@Configuration
public class MapperConfiguration {

    @Bean
    public MapperFacade mapperFacade(Mapper[] mappers) {
        return new ConfigurableMapper() {
            @Override
            protected void configure(MapperFactory factory) {
                for(Mapper mapper : mappers) {
                    mapper.configure(factory);
                }
            }
        };
    }

}
