package org.TeamDream.NaumenShop.models;

import org.TeamDream.NaumenShop.DB.DataBase;
import org.TeamDream.NaumenShop.DB.models.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class WebModelsToBD {
    public static HashMap<String,Object> AddNewCard(CardModel card){
        HashMap<String,Object> result = new HashMap<>();
        int priceId = DataBase.writeObj(new Price(card.price,card.bonusPrice,card.oldPrice));
        int descriptionId = DataBase.writeObj(new Description(card.description));
        int statusId = DataBase.writeObj(new Status(card.status));
        int galleryId= DataBase.writeObj( new Gallery());
        Arrays.stream(card.photos.split(";")).map((e)->DataBase.writeObj(new Image(e,galleryId)));
        DataBase.writeObj(new Card(card.name,priceId,card.seller_id,descriptionId,statusId,card.category_id,galleryId));
        return result;
    }
    public static void RemoveCard(ReCardModel recard){
        DataBase.removeCard(recard.getId());
    }
}
