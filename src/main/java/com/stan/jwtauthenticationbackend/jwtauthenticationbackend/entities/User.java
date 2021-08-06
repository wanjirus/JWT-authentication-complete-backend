package com.stan.jwtauthenticationbackend.jwtauthenticationbackend.entities;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Data
@Entity
//@Table(name="user")
@Table(name="user_table")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="user_name", unique = true)
    private String userName;
    @Column(name="user_key")
    private String password;
    @Column(name="created_at")
    private String createdAt;
    @Column(name="updated_On")
    private String updatedAt;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="email")
    private String email;
    @Column(name="phone_number")
    private String phoneNumber;
    @Column(name="enabled")
    private Boolean enabled;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "auth_authority",
            joinColumns = @JoinColumn(referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(referencedColumnName = "id"))
    private List<Authorities> authorities;

}

