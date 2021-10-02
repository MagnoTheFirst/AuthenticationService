package com.example.authenticationservicerolethedice.appuser.service;

import com.example.authenticationservicerolethedice.appuser.AppUser;
import com.example.authenticationservicerolethedice.appuser.repository.AppUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor  //Durch diese Lombok annotation wird der COntructor automatisch generiert
public class AppUserService implements UserDetailsService {

    //Durch %email wir die vom user eingegebene email adresse in der error message ausgegeben
    private final static String USER_NOT_FOUND_MSG = "Der User %email konnte nicht gefunden werden";
    private final AppUserRepository appUserRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return appUserRepository.findByEmail(email).orElseThrow(() ->
                new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email)));
    }

    public String signUpUser(AppUser appUser){
        boolean userExists = appUserRepository.findByEmail(appUser.getEmail())
                .isPresent();
        if(userExists){
            throw new IllegalStateException("Diese email ist bereits registriert");
        }

        String encodedPassword = bCryptPasswordEncoder.encode(appUser.getPassword());

        appUser.setPassword(encodedPassword);

        appUserRepository.sa

        //TODO: Send confirmation token

        return "it works";
    }

}
