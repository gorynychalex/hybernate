package ru.popovich.database;

import org.hibernate.annotations.Generated;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class User implements Serializable {

    private static final long serialVersionUID = 123456789;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    @Column(name = "users_id_seq")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String firstname;
    private String lastname;
    private String password;

    public User(){}


    public User(String firstname, String lastname, String password, Service service) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.service = service;
    }

    @ManyToOne
    @JoinColumn(name = "service")
    private Service service;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
