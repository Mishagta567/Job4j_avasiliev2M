package ru.job4j.ioс00;


/**
 * Simple class for UserStore class, to work with user-data as an object
 */

public class UserStorage {

   private final Storage storage;

   public UserStorage() {
      System.out.println("UserStorage awoke, no param");
      storage = null;
   }

   public UserStorage(final Storage storage) {
      this.storage = storage;
      System.out.println("UserStorage awoke with param");
   }

   public void add(User user) {
      this.storage.add(user);
      System.out.println("UserStorage add done");
   }

}
