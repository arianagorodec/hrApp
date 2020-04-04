package com.hrproj.entity;

import com.hrproj.entity.enums.RoleEnum;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name="user")

public class User implements UserDetails {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name= "increment", strategy= "increment")
    @Column(name = "id_user", length = 11, nullable = false)
    private long id;

    @Transient
    private String passwordConfirm;


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Role> roles;

    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;
//    @Column(name="access")
//    @Enumerated(EnumType.STRING)
 //   private RoleEnum access;

    @OneToOne(optional = false, mappedBy="user", cascade = CascadeType.ALL)
    public Employee employee;

    @OneToOne(optional = false, mappedBy="user", cascade = CascadeType.ALL)
    private Candidate candidate;

    public User() {
    }

    public User(String passwordConfirm, Set<Role> roles, String login, String password, Employee employee, Candidate candidate) {
        this.passwordConfirm = passwordConfirm;
        this.roles = roles;
        this.username = login;
        this.password = password;
        this.employee = employee;
        this.candidate = candidate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return (Collection<? extends GrantedAuthority>) getRoles();
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

}
