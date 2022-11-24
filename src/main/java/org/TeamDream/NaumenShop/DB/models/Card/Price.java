package org.TeamDream.NaumenShop.DB.models.Card;

import org.TeamDream.NaumenShop.DB.models.Card.IBdModel;

import javax.persistence.*;
import java.util.Map;
@Entity
@Table(name = "price_table")
public class Price implements IBdModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int current_price;
    private int old_price;
    private int bonus_price;
    public Price() {
    }
    public Price(int cur,int old,int bonus) {
        this.current_price = cur;
        this.old_price = old;
        this.bonus_price = bonus;
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
