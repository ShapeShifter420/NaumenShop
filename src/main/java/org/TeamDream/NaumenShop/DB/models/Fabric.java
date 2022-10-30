package org.TeamDream.NaumenShop.DB.models;

import org.TeamDream.NaumenShop.DB.DataBase;

import java.util.List;

public class Fabric{
    public static Status getStatus(int id){return  (Status) DataBase.getObject(id,Status.class);}
    public static Seller getBSeller(int id){return (Seller) DataBase.getObject(id,Seller.class);}
    public static Category getCategory(int id){return (Category) DataBase.getObject(id, Category.class);}
    public static Price getPrice(int id){return (Price)DataBase.getObject(id,Price.class);}
    public static Description getDescription(int id){return (Description)DataBase.getObject(id,Description.class);}

    public static List getImages(int id){return DataBase.getImagesFromGallery(id);}
}
