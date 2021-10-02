package com.example.authenticationservicerolethedice.registration.service;


import com.example.authenticationservicerolethedice.appuser.AppUser;
import com.example.authenticationservicerolethedice.appuser.AppUserRole;
import com.example.authenticationservicerolethedice.appuser.service.AppUserService;
import com.example.authenticationservicerolethedice.registration.request.RegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final AppUserService appUserService;
    private EmailValidator emailValidator;

    public String register(RegistrationRequest request){
        boolean isValidEmail = emailValidator.test(request.getEmail());
        if(!isValidEmail){
            throw new IllegalStateException("email ist nicht gültig");
        }
        return appUserService.signUpUser(new AppUser(request.getFirstname(),request.getLastname(), request.getEmail(),request.getPassword(),AppUserRole.USER));
    }

}
