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
    @Column(name = "pasp_ser", length = 9)
    private String pasp_ser;
    @Column(name = "pasp_id",length = 14)
    private String pasp_id;
    @Column(name = "pasp_date")
    private Date pasp_date;
    @Column(name = "pasp_who")
    private String pasp_who;
    @Column(name = "rate")
    private double rate;
    @Column(name = "mobphone")
    private String mobphone;
    @Column(name = "bankAccount")
    private String bankAccount;
    @Column(name = "isWorking")
    private boolean isWorking;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name="id_user", unique = true, nullable = false, updatable = false)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_post", nullable = false)
    private OrganizationStructure post;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "employee", cascade = CascadeType.ALL)
    private Set<Timetable> timetableSet;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "employee", cascade = CascadeType.ALL)
    private Set<Allowance> allowances;

    public Employee(String surname, String name, String patronymic, Date birthday, double rate, String mobphone,  String bankAccount, boolean isWorking, User user, OrganizationStructure post, Set<Timetable> timetableSet, Set<Allowance> allowances) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.birthday = birthday;
        this.rate = rate;
        this.mobphone = mobphone;
        this.bankAccount = bankAccount;
        this.isWorking = isWorking;
        this.user = user;
        this.post = post;
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

    public OrganizationStructure getPost() {
        return post;
    }

    public void setPost(OrganizationStructure post) {
        this.post = post;
    }

    public boolean isWorking() {
        return isWorking;
    }

    public void setWorking(boolean working) {
        isWorking = working;
    }
}
