package pl.edu.wat.share.cash.web.factory;

import com.github.ggeorgovassilis.springjsonmapper.spring.SpringRestInvokerProxyFactoryBean;
import groovy.lang.Singleton;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import pl.edu.wat.share.cash.common.rest.CreditCardRest;
import pl.edu.wat.share.cash.common.rest.GroupRest;
import pl.edu.wat.share.cash.common.rest.PersonRest;
import pl.edu.wat.share.cash.common.rest.TransactionRest;
import pl.edu.wat.share.cash.web.rest.invoker.OAuth2SpringRestInvokerProxyFactoryBean;

/**
 * Created by Kamil Przyborowski
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018.
 */
@Component
@Singleton
public class RestBeanFactory {

    @Value("${engine.url}")
    private String restUrl;

    private SpringRestInvokerProxyFactoryBean getRestInvokerForInterface(Class<?> clazz) {
        SpringRestInvokerProxyFactoryBean invoker = new OAuth2SpringRestInvokerProxyFactoryBean();
        invoker.setBaseUrl(restUrl);
        invoker.setRemoteServiceInterfaceClass(clazz);
        return invoker;
    }

    @Bean(name = "PersonRest")
    public SpringRestInvokerProxyFactoryBean personRest() {
        return getRestInvokerForInterface(PersonRest.class);
    }

    @Bean(name = "TransactionRest")
    public SpringRestInvokerProxyFactoryBean transactionRest() {
        return getRestInvokerForInterface(TransactionRest.class);
    }

    @Bean(name = "CreditCardRest")
    public SpringRestInvokerProxyFactoryBean creditCardRest() {
        return getRestInvokerForInterface(CreditCardRest.class);
    }

    @Bean(name = "GroupRest")
    public SpringRestInvokerProxyFactoryBean groupRest() {
        return getRestInvokerForInterface(GroupRest.class);
    }
}
