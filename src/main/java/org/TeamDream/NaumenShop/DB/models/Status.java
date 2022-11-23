package org.TeamDream.NaumenShop.DB.models;

import org.TeamDream.NaumenShop.DB.DataBase;

import javax.persistence.*;
import java.util.Map;

@Entity
@Table(name = "status_table")
public class Status  implements IBdModel{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String status;

    public Status(boolean status) {
        this.status = status ? "InStock":"OutStock";
    }
    public Status() {
    }
    public int getId() {
        return id;
    }
    public Map getMap(){
        return Map.of(
                "id",this.id,
                "status",this.status
        );}
}
