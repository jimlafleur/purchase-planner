package com.example.purchaseplanner.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "purchase")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private int count;
    private double coast;
    private Date date;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "shopping_list_id")
    private ShoppingList shoppingList;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category category;

    public Purchase() {
    }

    public Purchase(String name, int count, double coast, Category category) {
        this.name = name;
        this.count = count;
        this.coast = coast;
        this.date = new Date();
        this.category = category;
    }

    public Purchase(String name, int count, double coast) {
        this.name = name;
        this.count = count;
        this.coast = coast;
        this.date = new Date();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getCoast() {
        return coast;
    }

    public void setCoast(double coast) {
        this.coast = coast;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
