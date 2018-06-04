package pl.edu.wat.share.cash.sso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * Created by Kamil Przyborowski, Date: 29.05.2018
 * Copyright by Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018
 */
@SpringBootApplication
@EnableResourceServer
@EnableAsync
public class SsoServerApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SsoServerApplication.class, args);
    }

}
