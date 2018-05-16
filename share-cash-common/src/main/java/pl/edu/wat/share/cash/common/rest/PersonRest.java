package pl.edu.wat.share.cash.common.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.wat.share.cash.common.rest.base.BaseRest;

/**
 * Created by Kamil Przyborowski
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018.
 */
@RequestMapping(PersonRest.PATH)
public interface PersonRest extends BaseRest {
    String PATH = BASE_PATH + "person";


}
