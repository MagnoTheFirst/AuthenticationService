package com.example.authenticationservicerolethedice.registration.controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.authenticationservicerolethedice.registration.request.RegistrationRequest;
import com.example.authenticationservicerolethedice.registration.service.RegistrationService;

@RestController
@RequestMapping(path = "api/v1/registration") //@RequestMapping gibt an durch welchen pfad der Endpoint erreichbar sein soll. Ohne ihn wäre der Pfad einfach Root
@AllArgsConstructor
public class UserRegistrationController {

    private RegistrationService registrationService;

    @PostMapping
    public String register(@RequestBody RegistrationRequest request){
        return registrationService.register(request);
    }

}
