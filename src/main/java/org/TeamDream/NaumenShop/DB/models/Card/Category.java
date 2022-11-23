package org.TeamDream.NaumenShop.DB.models.Card;

import javax.persistence.*;
import java.util.Map;
@Entity
@Table(name = "category_table")
public class Category  implements IBdModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    public Category() {
    }

    public int getId() {
        return id;
    }
    public Map getMap(){
        return Map.of(
                "id",this.id,
                "name",this.name
        );}
}
