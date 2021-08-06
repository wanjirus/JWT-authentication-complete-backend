package com.stan.jwtauthenticationbackend.jwtauthenticationbackend;

import com.stan.jwtauthenticationbackend.jwtauthenticationbackend.entities.Authorities;
import com.stan.jwtauthenticationbackend.jwtauthenticationbackend.entities.User;
import com.stan.jwtauthenticationbackend.jwtauthenticationbackend.repositories.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class JwtAuthenticationBackendApplication {
@Autowired
private PasswordEncoder passwordEncoder;
@Autowired
private UserDetailsRepository userDetailsRepository;


    public static void main(String[] args) {
        SpringApplication.run(JwtAuthenticationBackendApplication.class, args);
    }

   @PostConstruct
   protected void init(){
       List<Authorities> authoritiesList=new ArrayList<>();
    authoritiesList.add(createAuthorities("USER", "User role"));
    authoritiesList.add(createAuthorities("ADMIN", "Admin role"));
    User user=new User();
    user.setUserName("stanley");
    user.setFirstName("stanley");
    user.setLastName("Mburu");
    user.setPassword(passwordEncoder.encode("stan"));
    user.setEnabled(true);
    userDetailsRepository.save(user);
    }

    private Authorities createAuthorities(String roleCode, String roleDescription) {
    Authorities authorities=new Authorities();
    authorities.setRoleCode(roleCode);
   authorities.setRoleDescription(roleDescription);
    return authorities;
    }
}
