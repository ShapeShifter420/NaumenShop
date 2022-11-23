package org.TeamDream.NaumenShop.models;

import org.TeamDream.NaumenShop.DB.DataBase;
import org.TeamDream.NaumenShop.DB.models.Card.*;

import java.util.Arrays;
import java.util.HashMap;

public class WebModelsToBD {
    public static HashMap<String,Object> AddNewCard(CardModel card){
        HashMap<String,Object> result = new HashMap<>();
        System.out.println(card.getPhotos());
        int priceId = DataBase.writeObj(new Price(card.price,card.bonusPrice,card.oldPrice));
        int descriptionId = DataBase.writeObj(new Description(card.description));
        int statusId = DataBase.writeObj(new Status(card.status));
        int galleryId= DataBase.writeObj( new Gallery());
        for (String photo:card.getPhotos().split(";")) {
            DataBase.writeObj(new Image(photo,galleryId));
        }
        DataBase.writeObj(new Card(card.name,priceId,card.seller_id,descriptionId,statusId,card.category_id,galleryId));
        return result;
    }
    public static void RemoveCard(ReCardModel recard){
        DataBase.removeCard(recard.getId());
    }
}
