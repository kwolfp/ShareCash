package pl.edu.wat.share.cash.web.rest.invoker;

import com.github.ggeorgovassilis.springjsonmapper.spring.SpringRestInvokerProxyFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Kamil Przyborowski
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018.
 */
public class OAuth2SpringRestInvokerProxyFactoryBean extends SpringRestInvokerProxyFactoryBean {

    @Autowired
    OAuth2ProtectedResourceDetails resourceDetails;

    @Autowired
    OAuth2ClientContext clientContext;


    @Override
    protected RestTemplate constructDefaultRestTemplate() {
        return new OAuth2RestTemplate(resourceDetails, clientContext);
    }

}
