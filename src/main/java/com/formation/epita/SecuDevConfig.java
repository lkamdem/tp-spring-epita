package com.formation.epita;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Profile("!production")  // on indique qu'on charge cette classe de config pour tout profil different de production
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        securedEnabled = true,   // permet de mettre les @Secured("ROLE_ADMIN")
        jsr250Enabled = true,    // permet de mettre les @RolesAllowed("ROLE_ADMIN")
        prePostEnabled = true)
public class SecuDevConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
                .withUser("toto")
                .password(passwordEncoder().encode("123"))
                .authorities("ROLE_USER")
                .and()
                .withUser("admin")
                .password(passwordEncoder().encode("123"))
                .authorities("ROLE_ADMIN");
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
           .authorizeRequests()
                .antMatchers("/unsecured/**").permitAll()  // on donne l'acces public à tous les requetes commencant par /unsecured
                .antMatchers(HttpMethod.GET,"/login").permitAll() // ici la methode get /login est autorisé
                .antMatchers(HttpMethod.POST,"/login").authenticated() // on demande que les methode post /login soit authentifié
                .antMatchers(
                        "/", "/csrf",
                        "/v2/api-docs",
                        "/swagger-resources/**",
                        "/swagger-ui.html",
                        "/webjars/**"
                ).permitAll()
                .anyRequest().authenticated()
            .and()// on cloture ici le bloc sur authorizeRequests
//            .httpBasic()    // on active l'authentification sur chaque requete ==> stateless (par defaut il ya creation d'un cookie)
                .formLogin()  // on reactive la redictection automatique vers la page de login fourni par spring security
                .successHandler((HttpServletRequest, HttpServletResponse, authentication) ->
                        { HttpServletResponse.getWriter().println("Authentification effectué !");
                        })
                .and()
                .logout()
//                .logoutUrl("/logout")   // on peut redefinir cet url par defaut
                .logoutSuccessHandler((HttpServletRequest, HttpServletResponse, authentication) ->
                { HttpServletResponse.getWriter().println("Logout effectué !");
                })
//        .and()
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .exceptionHandling()
                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
        .and()
        .csrf().disable()
                .headers().frameOptions().disable()
        ;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
