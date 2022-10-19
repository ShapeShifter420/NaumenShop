package org.TeamDream.NaumenShop.DB;

import org.TeamDream.NaumenShop.DB.models.Card;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DataBase {

    public static Card getCard(int id){
        return HBSessionUtil.getSessionFactory().openSession().get(Card.class, id);
    }
}
