package org.TeamDream.NaumenShop.format;

import org.TeamDream.NaumenShop.DB.DataBase;
import org.TeamDream.NaumenShop.DB.models.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FullCard {
    private int id;
    private String name;
    private Price price;
    private Seller seller;
    private Description description;
    private Status status;
    private Category category;
    private int timestamp;
    private String url;

    private String otherlinks;

    private List images;
    public FullCard(Card card){
        this.id = card.getId();
        this.name = card.getName();
        this.timestamp = card.getTimestamp();
        this.url = card.getUrl();
        this.otherlinks = card.getOtherLinks();
        this.price = Fabric.getPrice(card.getPrice_id());
        this.seller = Fabric.getBSeller(card.getSeller_id());
        this.description = Fabric.getDescription(card.getDescription_id());
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
                "seller",this.seller.getMap(),
                "description",this.description.getMap(),
                "status",this.status.getMap(),
                "category",this.category.getMap()
        );}
}
