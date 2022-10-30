package org.TeamDream.NaumenShop.DB.models;

import org.TeamDream.NaumenShop.DB.DataBase;

import javax.persistence.*;
import java.util.Map;
@Entity
@Table(name = "price_table")
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int current_price;
    private int old_price;
    private int bonus_price;

    public Price() {
    }

    public int getId() {
        return id;
    }
    public Map getMap(){
        return Map.of(
                "id",this.id,
                "current_price",this.current_price,
                "old_price",this.old_price,
                "bonus_price",this.bonus_price
        );}

}
