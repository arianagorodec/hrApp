package com.hrproj.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="employee")

public class Employee {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id_employee", length = 11, nullable = false)
    private long id;

    //@Column(name = "id_post")
    //private int id_post;
    //@Column(name = "id_user")
    //private int id_user;
    @Column(name = "surname")
    private String surname;
    @Column(name = "name")
    private String name;
    @Column(name = "patronymic")
    private String patronymic;
    @Column(name = "birthday")
    private Date birthday;
    @Column(name = "rate")
    private double rate;
    @Column(name = "mobphone")
    private String mobphone;
    @Column(name = "email")
    private String email;
    @Column(name = "bankAccount")
    private String bankAccount;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name="id_user", unique = true, nullable = false, updatable = false)
    private User user;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "employee", cascade = CascadeType.ALL)
    private Set<OrganizationStructure> posts;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "employee", cascade = CascadeType.ALL)
    private Set<Timetable> timetableSet;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "employee", cascade = CascadeType.ALL)
    private Set<Allowance> allowances;

    public Employee(String surname, String name, String patronymic, Date birthday, double rate, String mobphone, String email, String bankAccount, User user, Set<OrganizationStructure> posts, Set<Timetable> timetableSet, Set<Allowance> allowances) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.birthday = birthday;
        this.rate = rate;
        this.mobphone = mobphone;
        this.email = email;
        this.bankAccount = bankAccount;
        this.user = user;
        this.posts = posts;
        this.timetableSet = timetableSet;
        this.allowances = allowances;
    }

    public Employee() {
    }

    public Set<Timetable> getTimetableSet() {
        return timetableSet;
    }

    public void setTimetableSet(Set<Timetable> timetableSet) {
        this.timetableSet = timetableSet;
    }

    public Set<Allowance> getAllowances() {
        return allowances;
    }

    public void setAllowances(Set<Allowance> allowances) {
        this.allowances = allowances;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getMobphone() {
        return mobphone;
    }

    public void setMobphone(String mobphone) {
        this.mobphone = mobphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<OrganizationStructure> getPosts() {
        return posts;
    }

    public void setPosts(Set<OrganizationStructure> posts) {
        this.posts = posts;
    }
}
