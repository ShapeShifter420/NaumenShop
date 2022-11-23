package org.TeamDream.NaumenShop.DB.models;

import org.TeamDream.NaumenShop.DB.models.Card.IBdModel;

public class User  implements IBdModel {
    private int id;

    @Override
    public int getId() {
        return id;
    }
}
