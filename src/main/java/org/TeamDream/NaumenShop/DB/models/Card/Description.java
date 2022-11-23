package org.TeamDream.NaumenShop.DB.models.Card;

import javax.persistence.*;
import java.util.Map;

@Entity
@Table(name = "description_table")
public class Description  implements IBdModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String description;

    public Description() {
    }
    public Description(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }
    public Map getMap(){
        return Map.of(
                "id",this.id,
                "description",this.description
        );}
}
