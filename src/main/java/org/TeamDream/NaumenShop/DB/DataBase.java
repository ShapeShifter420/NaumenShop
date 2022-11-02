package org.TeamDream.NaumenShop.DB;

import org.hibernate.Session;

import java.util.List;

public class DataBase {

    public static Object getObject(int id,Class objClass){
        return HBSessionUtil.getSessionFactory().openSession().get(objClass, id);
    }

    public static List getImagesFromGallery(int id){
        //System.out.println(String.format("select src from images_table where gallery_id == %d;",id));
        try (Session session = HBSessionUtil.getSessionFactory().openSession()) {
            return session.createSQLQuery(String.format("select src from images_table where gallery_id = %d;",id)).list();
        }
    }

    public static List getCardsByName(String name,int offset){
        try (Session session = HBSessionUtil.getSessionFactory().openSession()) {
            return session.createSQLQuery(String.format("select * from cardtable where name like \"%d\" limit 100;",name)).list();
        }
    }
}
