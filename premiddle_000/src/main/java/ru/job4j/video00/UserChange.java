package ru.job4j.video00;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Timestamp;

public class UserChange {

   public static void main(String[] args) {
      SessionFactory factory = new Configuration()
              .configure() // configure setting from hibernate,cfg,xml
              .buildSessionFactory();
      Session session = factory.openSession();
      session.beginTransaction();
      User00 user00 = new User00();
      user00.setId(18);
      user00.setLogin("agent007");
      user00.setPassword("007");
      user00.setName("Agent 0 0 7");
      user00.setEmail("007@mail.ru");
      user00.setRole(2);
      user00.setInsertedDate(new Timestamp(System.currentTimeMillis()));

      session.update(user00);
      //System.out.println(session.createQuery("from users").list());
      session.getTransaction().commit();
      session.close();
      factory.close();
   }
}
