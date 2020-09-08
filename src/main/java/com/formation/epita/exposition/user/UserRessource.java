package com.formation.epita.exposition.user;


import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRessource {

    @GetMapping("/user")
    public String getUser(Authentication authentication){
        return "you are " + authentication.getName() + " with roles(s)" + authentication.getAuthorities();
    }

    @GetMapping("/user2")
    public String getUser2(){
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        String role = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString();
        return "you are " + name + " with roles(s)" + role;
    }

    @GetMapping("/admin")
    @Secured("ROLE_ADMIN")
    public String isAdmin(){
        return "Congrats ! you are admin ";
    }
}
