package org.TeamDream.NaumenShop.DB.models;

import org.TeamDream.NaumenShop.DB.DataBase;

import javax.persistence.*;
import java.util.Map;
@Entity
@Table(name = "seller_table")
public class Seller  implements IBdModel{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String seller_name;

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
