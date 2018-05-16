package pl.edu.wat.share.cash.engine.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import pl.edu.wat.share.cash.engine.EngineApplication;

/**
 * Created by Kamil Przyborowski
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018.
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackageClasses = EngineApplication.class, basePackages = {"pl.edu.wat.share.cash.engine.repository"})
@EntityScan(basePackages = {"pl.edu.wat.share.cash.domain.entity"})
public class JpaConfiguration {

}
