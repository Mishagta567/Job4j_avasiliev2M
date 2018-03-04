package ru.job4j.ioс00;

/**
 * Simple class for UserStore class, to work with user-data as an object
 */

public class JdbcStorage implements Storage {

   public JdbcStorage() {
      System.out.println("JdbcStorage awoke");
   }

   @Override
   public void add(User user) {
      System.out.println("JdbcStorage add done");
   }

}
