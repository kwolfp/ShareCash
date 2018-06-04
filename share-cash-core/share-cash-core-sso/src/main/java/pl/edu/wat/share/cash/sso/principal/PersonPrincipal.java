package pl.edu.wat.share.cash.sso.principal;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import pl.edu.wat.share.cash.domain.entity.Person;

import java.util.Collection;

/**
 * Created by Kamil Przyborowski, Date: 04.06.2018
 * Copyright by Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018
 */
@Data
public class PersonPrincipal implements UserDetails {

    private String name;
    private String userName;
    private String password;

    public PersonPrincipal(Person person) {
        this.name = person.getName();
        this.userName = person.getUserName();
        this.password = person.getPassword();
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
