package pl.edu.wat.share.cash.sso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Kamil Przyborowski, Date: 04.06.2018
 * Copyright by Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {

    @RequestMapping(value = "/signIn", method = RequestMethod.GET)
    public String getSignInPage() {
        return "signIn";
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.GET)
    public String getSignUpPage() {

        return "signUp";
    }

}
