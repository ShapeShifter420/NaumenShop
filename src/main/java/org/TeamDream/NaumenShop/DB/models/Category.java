package org.TeamDream.NaumenShop.DB.models;

import org.TeamDream.NaumenShop.DB.DataBase;

import javax.persistence.*;
import java.util.Map;
@Entity
@Table(name = "category_table")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
