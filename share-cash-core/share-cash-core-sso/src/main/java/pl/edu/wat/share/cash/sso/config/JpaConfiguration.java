package pl.edu.wat.share.cash.sso.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import pl.edu.wat.share.cash.sso.AuthorizationServerApplication;

/**
 * Created by Kamil Przyborowski, Date: 28.05.2018
 * Copyright by Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackageClasses = AuthorizationServerApplication.class,
        basePackages = {"pl.edu.wat.share.cash.sso.repository"})
@EntityScan(basePackages = {"pl.edu.wat.share.cash.domain.entity"})
public class JpaConfiguration {

}
