package ru.example.collections;

import java.util.*;

/**
 * Первоый тестовый класс для проверки настроек.
 * @author   A_Vasiliev
 * @since    22.12.2017
 * @version  1.0.0
 */

public class ListExample {

   static class User implements Comparable<User> {
      private final String name;

      User(String name) {
         this.name = name;
      }

      @Override
      public boolean equals(Object o) {
         if (this == o) return true;
         if (o == null || getClass() != o.getClass()) return false;

         User user = (User) o;

         return name != null ? name.equals(user.name) : user.name == null;
      }

      @Override
      public int hashCode() {
         return name != null ? name.hashCode() : 0;
      }

      @Override
      public String toString() {
         return "User{" +
               "name=='" + name + '\'' +
               '}';
      }

      @Override
      public int compareTo(User o) {
         return this.name.compareTo(o.name);
      }
   }

   public static void main(String[] arg) {
      Set<User> users = new TreeSet<>();
      users.addAll(Arrays.asList(new User("zuma"), new User("ivan"), new User("petr")));
      System.out.println(users);

      /**
      List<User> users = new ArrayList<User>();
      users.addAll(Arrays.asList(new User("zuma"), new User("ivan"), new User("petr")));
      System.out.println(users);
      users.sort(
            new Comparator<User>() {
               @Override
               public int compare(User o1, User o2) {
                  return o1.name.compareTo(o2.name);
               }
            }
      );
      System.out.println(users);

       * boolean result = users.equals("Petr");
      for (User user : users) {
         System.out.println(user);
      }
      Iterator<User> it = users.iterator();
      System.out.println(it.next());

      Iterator<User> it = users.iterator();
      while(it.hasNext()) {
         System.out.println(it.next());
      }  // */

   }
}