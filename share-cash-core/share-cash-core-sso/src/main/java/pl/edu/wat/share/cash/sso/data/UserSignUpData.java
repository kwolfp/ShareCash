package pl.edu.wat.share.cash.sso.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Kamil Przyborowski
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSignUpData {
    private String name;
    private String last_name;
    private String email;
    private String username;
    private String password;
    private String password_r;
}
