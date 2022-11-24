package org.TeamDream.NaumenShop.DB;

import org.TeamDream.NaumenShop.DB.models.Card.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.PropertySource;

@PropertySource(value = {"classpath:application.properties"})
public class HBSessionUtil {
    private static SessionFactory sessionFactory;

    public HBSessionUtil() {
    }

    public static SessionFactory getSessionFactory() {
            try {
                //FileInputStream fileInputStream = new FileInputStream("application.properties");
                //Properties property = new Properties();
                //property.load(fileInputStream);
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Card.class);
                configuration.addAnnotatedClass(Category.class);
                configuration.addAnnotatedClass(Description.class);
                configuration.addAnnotatedClass(Price.class);
                configuration.addAnnotatedClass(Status.class);
                configuration.addAnnotatedClass(Seller.class);
                configuration.addAnnotatedClass(Gallery.class);
                configuration.addAnnotatedClass(Image.class);
                //System.out.println(name + password);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
                //fileInputStream.close();

            } catch (Exception e) {
                System.out.println("Исключение!" + e);
            }
        return sessionFactory;
    }
}
