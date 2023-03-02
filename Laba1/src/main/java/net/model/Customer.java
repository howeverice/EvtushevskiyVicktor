package net.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


@Entity
@Table(name = "user")
@Getter
@Setter
@ToString

public class Customer  {

    @Id
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "surname")
    private String surname;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "email")
    private String email;

    @Column(name = "job")
    private String job;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;
}

