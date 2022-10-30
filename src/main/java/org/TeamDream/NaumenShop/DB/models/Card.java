package org.TeamDream.NaumenShop.DB.models;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Map;

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

    private int gallery_id;
    private int timestamp;
    private String url;
    private String other_links;


    public Card() {
    }

    public Card(String name, int age) {
        this.name = name;
    }

    public int getId() {
        return this.id;
    }
    public int getPrice_id() {
        return this.price_id;
    }
    public int getSeller_id() {
        return this.seller_id;
    }
    public int getStatus_id() {
        return this.status_id;
    }
    public int getDescription_id() {
        return this.description_id;
    }

    public int getTimestamp() {
        return this.timestamp;
    }

    public int getGallery_id() {
        return this.gallery_id;
    }

    public String getUrl(){return this.url;}
    public String getOtherLinks(){return this.other_links;}
    public int getCategory_id() {
        return this.category_id;
    }

    public String getName() {
        return name;
    }

}
