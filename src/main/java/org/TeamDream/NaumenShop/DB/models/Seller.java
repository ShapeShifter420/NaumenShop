package org.TeamDream.NaumenShop.DB.models;

import org.TeamDream.NaumenShop.DB.DataBase;

import javax.persistence.*;
import java.util.Map;
@Entity
@Table(name = "seller_table")
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int seller_name;

    public Seller() {
    }
    public int getId() {
        return id;
    }
    public Map getMap(){
        return Map.of(
                "id",this.id,
                "seller_name",this.seller_name
        );}
}
