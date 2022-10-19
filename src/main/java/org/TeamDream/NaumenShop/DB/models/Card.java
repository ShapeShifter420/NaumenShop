package org.TeamDream.NaumenShop.DB.models;

import javax.persistence.*;
@Entity
@Table(name = "cardtable")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int price_id;
    private int seller_id;
    private int description_id;
    private int status_id;
    private int category_id;
    private int timestamp;
    private String url;


    public Card() {
    }

    public Card(String name, int age) {
        this.name = name;
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

    @Override
    public String toString() {
        return String.format("{name:\"%s\"}",name);
    }

}
