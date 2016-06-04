package ru.popovich.database;

import javax.persistence.*;

@Entity
@Table(name = "service")
public class Service {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    @Column(name = "services_id_seq")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private float price;
    private float credit;

    public Service() {}

    public Service(String name) {
        this.name = name;
        this.price = 0.0F;
        this.credit = 0.0F;
    }

    public Service(String name, float price, float credit) {
        this.name = name;
        this.price = price;
        this.credit = credit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getCredit() {
        return credit;
    }

    public void setCredit(float credit) {
        this.credit = credit;
    }
}
