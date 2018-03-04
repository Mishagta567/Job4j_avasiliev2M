package ru.job4j.todo01;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class AllTodoItems {

   public List<TodoItem> getAllItems() {
      SessionFactory factory = new Configuration()
              .configure() // configure setting from hibernate,cfg,xml
              .buildSessionFactory();
      Session session = factory.openSession();
      session.beginTransaction();
      List<TodoItem> allTodoItems = session.createQuery("from TodoItem ORDER BY id").list();
      System.out.println(session.createQuery("from TodoItem").list());
      session.getTransaction().commit();
      session.close();
      factory.close();
      return allTodoItems;
   }

}
