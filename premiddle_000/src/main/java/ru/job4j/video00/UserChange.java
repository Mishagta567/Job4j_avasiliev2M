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
      User01 user01 = new User01();
      user01.setId(18);
      user01.setLogin("agent007");
      user01.setPassword("007");
      user01.setName("Agent 0 0 7");
      user01.setEmail("007@mail.ru");
      user01.setRole(2);
      user01.setInsertedDate(new Timestamp(System.currentTimeMillis()));

      session.update(user01);
      //System.out.println(session.createQuery("from users").list());
      session.getTransaction().commit();
      session.close();
      factory.close();
   }
}
