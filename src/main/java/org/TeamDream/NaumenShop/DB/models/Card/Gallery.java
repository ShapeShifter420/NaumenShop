package org.TeamDream.NaumenShop.DB.models.Card;

import javax.persistence.*;

@Entity
@Table(name = "gallery_table")
public class Gallery  implements IBdModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public int getId() {
        return this.id;
    }
}
