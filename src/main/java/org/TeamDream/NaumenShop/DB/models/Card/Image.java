package org.TeamDream.NaumenShop.DB.models.Card;

import org.TeamDream.NaumenShop.DB.models.Card.IBdModel;

import javax.persistence.*;

@Entity
@Table(name = "image_table")
public class Image  implements IBdModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String src;
    private int gallery_id;

    public int getId() {
        return id;
    }

    public Image(String src, int gallery_id){
        this.src = src;
        this.gallery_id = gallery_id;
    }

    public Image() {

    }
}
