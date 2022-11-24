package org.TeamDream.NaumenShop.format;

import org.TeamDream.NaumenShop.DB.models.*;
import org.TeamDream.NaumenShop.DB.models.Card.Card;
import org.TeamDream.NaumenShop.DB.models.Card.Category;
import org.TeamDream.NaumenShop.DB.models.Card.Price;
import org.TeamDream.NaumenShop.DB.models.Card.Status;

import java.util.List;
import java.util.Map;

public class HalfCard {
    private int id;
    private String name;
    private Price price;
    private Status status;
    private Category category;
    private int timestamp;
    private String url;

    private String otherlinks;

    private List images;
    public HalfCard(Card card){
        this.id = card.getId();
        this.name = card.getName();
        this.timestamp = card.getTimestamp();
        this.url = card.getUrl();
        this.otherlinks = card.getOtherLinks();
        this.price = Fabric.getPrice(card.getPrice_id());
        this.status = Fabric.getStatus(card.getStatus_id());
        this.category =Fabric.getCategory(card.getCategory_id());
        this.images = Fabric.getImages(card.getGallery_id());
    }

    public Map getMap(){
        return Map.of(
                "id",this.id,
                "images",this.images,
                "name",this.name,
                "timestamp",this.timestamp,
                "url",this.url,
                "price",this.price.getMap(),
                "status",this.status.getMap(),
                "category",this.category.getMap()
        );}
}

