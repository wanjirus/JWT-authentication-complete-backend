package com.stan.jwtauthenticationbackend.jwtauthenticationbackend.entities;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
@Entity
@Table(name="auth_authority")
@Data
public class Authorities implements GrantedAuthority{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "role_code")
    private String roleCode;
    @Column(name = "role_description")
    private String roleDescription;

    @Override
    public String getAuthority() {
        return roleCode;
    }
}
/*
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }
}


 */