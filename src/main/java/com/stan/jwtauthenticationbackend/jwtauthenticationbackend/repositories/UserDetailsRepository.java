package com.stan.jwtauthenticationbackend.jwtauthenticationbackend.repositories;

import com.stan.jwtauthenticationbackend.jwtauthenticationbackend.entities.User;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserDetailsRepository extends JpaRepository<User, Long >{
 User findByUserName(String userName);
}

