package org.TeamDream.NaumenShop.DB;

import org.TeamDream.NaumenShop.DB.models.Card.Card;
import org.TeamDream.NaumenShop.DB.models.Card.IBdModel;
import org.TeamDream.NaumenShop.models.Filter;
import org.TeamDream.NaumenShop.DB.models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.thymeleaf.util.ArrayUtils;
import org.thymeleaf.util.StringUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DataBase {

    public static Object getObject(int id,Class objClass){
        return HBSessionUtil.getSessionFactory().getCurrentSession().get(objClass, id);
    }
    public static int writeObj(IBdModel obj){
        try (Session session = HBSessionUtil.getSessionFactory().openSession()) {
            Transaction tx1 = session.beginTransaction();
           session.save(obj);
           tx1.commit();
           session.close();
           return obj.getId();
        }
    }
    public static void removeCard(int id){
        try (Session session = HBSessionUtil.getSessionFactory().openSession()) {
            Transaction tx1 = session.beginTransaction();
            session.createQuery("DELETE FROM cardtable WHERE id = :id").setParameter("id", id).executeUpdate();
            tx1.commit();
            session.close();
        }
    }
    public static List getImagesFromGallery(int id) {
        System.out.println(String.format("select src from images_table where gallery_id == %d;", id));
        try (Session session = HBSessionUtil.getSessionFactory().getCurrentSession()) {
            //System.out.println(String.format("select src from images_table where gallery_id == %d;",id));
            try (Session session2 = HBSessionUtil.getSessionFactory().openSession()) {
                return session2.createSQLQuery(String.format("select src from images_table where gallery_id = %d;", id)).list();
            }
        }
    }

    private static List<User> _users = new ArrayList<>();

    public static Long registerUser(User newUser) {
        _users.add(newUser);
        return newUser.Id;
    }

    public static User findByUserName(String name) {
        return _users.stream().filter(user -> Objects.equals(user.Name, name)).findFirst().orElse(null);
    }

    public static List<Card> getCardsByName(String name,int offset){
        try (Session session = HBSessionUtil.getSessionFactory().openSession()) {
            return session.createSQLQuery("select * from cardtable where name like %:name% limit 100 offset :offset;")
                    .setParameter("offset", offset).setParameter("name", name).addEntity(Card.class).list();
        }
    }
    public static List<Card> getCardsByName(String name, int offset, String filter){
        try (Session session = HBSessionUtil.getSessionFactory().openSession()) {
            return session.createSQLQuery("select * from cardtable where name like %:name% :dopfilter limit 100 offset :offset;")
                    .setParameter("offset", offset)
                    .setParameter("name", name)
                    .setParameter("dopfilter",filter).addEntity(Card.class).list();
        }
    }
    public static List<Card> getCardsByIds(String[] ids){
        try (Session session = HBSessionUtil.getSessionFactory().openSession()) {
            return session.createSQLQuery("select * from cardtable where id in (:list)")
                    .setParameter("list",StringUtils.join(ids, " , ")).addEntity(Card.class).list();
        }
    }
}
