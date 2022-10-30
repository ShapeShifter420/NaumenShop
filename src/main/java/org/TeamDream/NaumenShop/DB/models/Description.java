package org.TeamDream.NaumenShop.DB.models;

import javax.persistence.*;
import java.util.Map;

@Entity
@Table(name = "description_table")
public class Description {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;

    public Description() {
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
