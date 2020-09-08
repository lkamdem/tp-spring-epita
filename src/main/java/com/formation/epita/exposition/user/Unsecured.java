package com.formation.epita.exposition.user;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Unsecured {

    @Value("${my.property}")   // je recupere ainsi la valeur de la propriete présente dans application.properties
    private String phrase;

    @GetMapping("/unsecured")
    public String methode1(){
        return phrase + " Je ne suis pas sécurisé";
    }
}
