package pl.edu.wat.share.cash.engine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Kamil Przyborowski
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018.
 */
@ComponentScan({"pl.edu.wat.share.cash.engine.config",
                "pl.edu.wat.share.cash.engine.controller",
                "pl.edu.wat.share.cash.engine.mapper",
                "pl.edu.wat.share.cash.engine.provider",
                "pl.edu.wat.share.cash.engine.service",
                "pl.edu.wat.share.cash.engine.repository",
                "pl.edu.wat.share.cash.common.session",
                "pl.edu.wat.share.cash.common.config"})
@SpringBootApplication
public class EngineApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(EngineApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(EngineApplication.class);
    }
}
