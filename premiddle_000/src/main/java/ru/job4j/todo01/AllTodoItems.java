package ru.job4j.todo01;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.job4j.video00.User;

import java.sql.Timestamp;
import java.util.List;

public class AllTodoItems {

   public List<TodoItem> getAllItems() {
      SessionFactory factory = new Configuration()
              .configure() // configure setting from hibernate,cfg,xml
              .buildSessionFactory();
      Session session = factory.openSession();
      session.beginTransaction();
      List<TodoItem> allItems = session.createQuery("from TodoItem").list();
      System.out.println(session.createQuery("from TodoItem").list());
      session.getTransaction().commit();
      session.close();
      factory.close();
      return allItems;
   }

}
