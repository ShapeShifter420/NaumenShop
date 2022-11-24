package org.TeamDream.NaumenShop.models;

public class CardModel {
    public String name;
    public int price;
    public int oldPrice;
    public int bonusPrice;
    public int seller_id;
    public String description;
    public boolean status = false;
    public int category_id;
    public String photos;


    public int getPrice(){
        return this.price;
    }
    public int getOldPrice(){
        return this.price;
    }
    public int getBonusPrice(){
        return this.price;
    }
    public String getName(){
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public void setBonusPrice(int bonusPrice) {
        this.bonusPrice = bonusPrice;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public void setSeller_id(int seller_id) {
        this.seller_id = seller_id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setOldPrice(int oldPrice) {
        this.oldPrice = oldPrice;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getSeller_id(){
        return this.seller_id;
    }

    public int getCategory_id(){
        return this.category_id;
    }
    public String getDescription(){
        return this.description;
    }
    public String getPhotos(){
        return this.photos;
    }
    public boolean getStatus(){
        return this.status;
    }

}
