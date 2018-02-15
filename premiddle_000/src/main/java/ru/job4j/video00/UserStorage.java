package ru.job4j.video00;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.job4j.video00.User;

import java.sql.Timestamp;

public class UserStorage {

   public static void main(String[] args) {
      SessionFactory factory = new Configuration()
              .configure() // configure setting from hibernate,cfg,xml
              .buildSessionFactory();
      Session session = factory.openSession();
      session.beginTransaction();
      User user = new User();
      user.setId(11);
      user.setLogin("login-1234---");
      user.setPassword("1234---");
      user.setName("Name 1234---");
      user.setEmail("-------=======@mail.ru");
      user.setRole(1);
      user.setInsertedDate(new Timestamp(System.currentTimeMillis()));

      session.update(user);
      //System.out.println(session.createQuery("from users").list());
      session.getTransaction().commit();
      session.close();
      factory.close();
   }
}
