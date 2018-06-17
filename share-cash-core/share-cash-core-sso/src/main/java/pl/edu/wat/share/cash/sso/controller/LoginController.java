package pl.edu.wat.share.cash.sso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.edu.wat.share.cash.common.dto.PersonDto;
import pl.edu.wat.share.cash.common.rest.PersonRest;
import pl.edu.wat.share.cash.domain.entity.Person;
import pl.edu.wat.share.cash.sso.data.UserSignUpData;
import pl.edu.wat.share.cash.sso.repository.PersonRepositorySso;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Kamil Przyborowski, Date: 04.06.2018
 * Copyright by Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    PersonRepositorySso personRepositorySso;

    @Autowired
    PasswordEncoder passwordEncoder;


    @RequestMapping(value = "/signIn", method = RequestMethod.GET)
    public String getSignInPage() {
        return "signIn";
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.GET)
    public String getSignUpPage() {
        return "signUp";
    }

    @RequestMapping(value = "/signUp/process", method = RequestMethod.POST)
    @ResponseBody
    public Boolean signUp(@RequestBody UserSignUpData userSignUpData) throws IOException {
        if(userSignUpData == null) {
            return null;
        }

        if(userSignUpData.getPassword() == null || userSignUpData.getPassword_r() == null) {
            return null;
        }

        if(userSignUpData.getEmail() == null || userSignUpData.getEmail().isEmpty()) {
            return null;
        }

        if(userSignUpData.getUsername() == null || userSignUpData.getUsername().isEmpty()) {
            return null;
        }

        if(!userSignUpData.getPassword().equals(userSignUpData.getPassword_r())) {
            return null;
        }

        String password = passwordEncoder.encode(userSignUpData.getPassword());

        Person person = new Person();
        person.setEmail(userSignUpData.getEmail());
        person.setUserName(userSignUpData.getUsername());
        person.setPassword(password);
        person.setLastName(userSignUpData.getLast_name());
        person.setName(userSignUpData.getName());

        Person created = personRepositorySso.save(person);

        return true;
    }

}
