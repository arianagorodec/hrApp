package com.hrproj.entity;

import com.hrproj.entity.enums.RoleEnum;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="user")

public class User {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name= "increment", strategy= "increment")
    @Column(name = "id_user", length = 11, nullable = false)
    private long id;

    @Column(name="login")
    private String login;
    @Column(name="password")
    private String password;
    @Column(name="access")
    @Enumerated(EnumType.STRING)
    private RoleEnum access;

    @OneToOne(optional = false, mappedBy="user", cascade = CascadeType.ALL)
    public Employee employee;

    @OneToOne(optional = false, mappedBy="user", cascade = CascadeType.ALL)
    private Candidate candidate;

    public User() {
    }

    public User(String login, String password, RoleEnum access, Employee employee, Candidate candidate) {
        this.login = login;
        this.password = password;
        this.access = access;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleEnum getAccess() {
        return access;
    }

    public void setAccess(RoleEnum access) {
        this.access = access;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }
}
