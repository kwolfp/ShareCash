package pl.edu.wat.share.cash.sso.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by Kamil Przyborowski, Date: 29.05.2018
 * Copyright by Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018
 */
@RestController
public class UserController {

    @RequestMapping(value = "/user/me", method = RequestMethod.GET)
    public Principal getUserPrincipal(Principal principal) {
        return principal;
    }

}
