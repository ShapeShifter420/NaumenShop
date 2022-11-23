package org.TeamDream.NaumenShop.DB.models.Card;

import javax.persistence.*;

@Entity
@Table(name = "cardtable")
public class Card implements IBdModel {
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

    public Card(String name,int price_id,int seller_id,int description_id,int status_id,int category_id,int gallery_id) {
        this.name = name;
        this.price_id = price_id;
        this.seller_id = seller_id;
        this.description_id = description_id;
        this.status_id = status_id;
        this.category_id = category_id;
        this.gallery_id = gallery_id;
        this.url = "";
        this.other_links = "";
        this.timestamp = 0;
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
