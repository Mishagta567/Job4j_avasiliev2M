package ru.job4j.ioс00;


/**
 * Simple class for UserStore class, to work with user-data as an object
 */

public class MemoryStorage  implements Storage {


   public MemoryStorage() {
      System.out.println("MemoryStorage awoke NO param");
   }

   @Override
   public void add(User user) {
      System.out.println("MemoryStorage add done");
   }

}
