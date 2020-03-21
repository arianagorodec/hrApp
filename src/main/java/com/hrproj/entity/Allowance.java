package com.hrproj.entity;

import org.hibernate.annotations.*;

import javax.persistence.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="allowance")

public class Allowance {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id", length = 11, nullable = false)
    private long id;

//    @Column(name = "id_employee")
//    private int id_employee;
    @Column(name = "name")
    private String name;
    @Column(name = "sum")
    private double sum;
    @Column(name = "month")
    private int month;
    @Column(name = "year")
    private int year;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_employee", nullable = false)
    private Employee employee;

    public Allowance() {
    }

    public Allowance(String name, double sum, int month, int year, Employee employee) {
        this.name = name;
        this.sum = sum;
        this.month = month;
        this.year = year;
        this.employee = employee;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
