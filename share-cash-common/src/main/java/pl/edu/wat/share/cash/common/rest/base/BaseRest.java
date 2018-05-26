package pl.edu.wat.share.cash.common.rest.base;

import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.wat.share.cash.common.rest.PersonRest;

/**
 * Created by Kamil Przyborowski
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018.
 */
@RequestMapping(PersonRest.PATH)
public interface BaseRest {
    String BASE_PATH = "/protected/";
}
