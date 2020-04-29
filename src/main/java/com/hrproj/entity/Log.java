package com.hrproj.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="log")
public class Log {
    @Id
    @GeneratedValue(generator = "native")
    @GenericGenerator(name= "native", strategy= "native")
    @Column(name = "id", length = 11, nullable = false)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user")
    private User user;

    @Column(name="info")
    private String info;

    @Column(name="date")
    private Date date;

    @Column(name="time")
    private LocalDateTime time;

}
