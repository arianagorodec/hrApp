package com.hrproj.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

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
    @Column(name = "gender")
    private String gender;
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
    @Column(name = "email")
    private String email;
    @Column(name = "mobphone")
    private String mobphone;
    @Column(name = "bankAccount")
    private String bankAccount;
    @Column(name = "isWorking")
    private int isWorking;

    @OneToOne(cascade = CascadeType.ALL)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name="id_user", unique = true, nullable = true, updatable = false)
    private User user = new User();


    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "id_post", nullable = false)
    private OrganizationStructure post;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "employee", cascade = CascadeType.ALL)
    private Set<Timetable> timetableSet;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "employee", cascade = CascadeType.ALL)
    private Set<Allowance> allowances;

    public Employee(String surname, String name, String patronymic, Date birthday, String gender, String email,String pasp_ser, String pasp_id, Date pasp_date, String pasp_who, double rate, String mobphone, String bankAccount, int isWorking, User user, OrganizationStructure post, Set<Timetable> timetableSet, Set<Allowance> allowances) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.birthday = birthday;
        this.email=email;
        this.gender = gender;
        this.pasp_ser = pasp_ser;
        this.pasp_id = pasp_id;
        this.pasp_date = pasp_date;
        this.pasp_who = pasp_who;
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

    public Employee(Employee e) {
        this.setId(e.getId());
        this.setSurname(e.getSurname());
        this.setName(e.getName());
        this.setPatronymic(e.getPatronymic());
        this.setBirthday(e.getBirthday());
        this.setGender(e.getGender());
        this.setEmail(e.getEmail());
        this.setPasp_ser(e.getPasp_ser());
        this.setPasp_id(e.getPasp_id());
        this.setPasp_date(e.getPasp_date());
        this.setPasp_who(e.getPasp_who());
        this.setRate( e.getRate());
        this.setMobphone(e.getMobphone());
        this.setBankAccount(e.getBankAccount());
        this.setWorking(e.getWorking());
        this.setUser(e.getUser());
        this.setPost(e.getPost());
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getRate() {
        return rate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public int getWorking() {
        return isWorking;
    }

    public void setWorking(int working) {
        isWorking = working;
    }

    public String getPasp_ser() {
        return pasp_ser;
    }

    public void setPasp_ser(String pasp_ser) {
        this.pasp_ser = pasp_ser;
    }

    public String getPasp_id() {
        return pasp_id;
    }

    public void setPasp_id(String pasp_id) {
        this.pasp_id = pasp_id;
    }

    public Date getPasp_date() {
        return pasp_date;
    }

    public void setPasp_date(Date pasp_date) {
        this.pasp_date = pasp_date;
    }

    public String getPasp_who() {
        return pasp_who;
    }

    public void setPasp_who(String pasp_who) {
        this.pasp_who = pasp_who;
    }
}
