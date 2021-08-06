package com.stan.jwtauthenticationbackend.jwtauthenticationbackend.services;

import com.stan.jwtauthenticationbackend.jwtauthenticationbackend.entities.User;
import com.stan.jwtauthenticationbackend.jwtauthenticationbackend.repositories.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService{
    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user=userDetailsRepository.findByUserName(username);
       if(null==user){
           throw new UsernameNotFoundException("User Not Found with userName " + username);
       }
        return (UserDetails) user;

    }
}
