package org.TeamDream.NaumenShop.DB;

import org.TeamDream.NaumenShop.DB.models.User;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DataBase {

    public static Object getObject(int id,Class objClass){
        return HBSessionUtil.getSessionFactory().getCurrentSession().get(objClass, id);
    }

    public static List getImagesFromGallery(int id){
        System.out.println(String.format("select src from images_table where gallery_id == %d;",id));
        try (Session session = HBSessionUtil.getSessionFactory().getCurrentSession()) {
            return session.createSQLQuery(String.format("select src from images_table where gallery_id = %d;",id)).list();
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
}
