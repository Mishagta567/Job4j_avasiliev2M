package ru.job4j.collections;

import ru.example.collections.ListExample;

import java.util.*;

/**
 * Первоый тестовый класс для проверки настроек.
 * @author   A_Vasiliev
 * @since    22.12.2017
 * @version  1.0.0
 */

public class SortUser {

   static class User implements Comparable<User> {
      private final String name;
      private final int age;

      User(String name, int age) {
         this.name = name;
         this.age = age;
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
               "age: " + age +
               ", name='" + name + '\'' +
               '}';
      }

      @Override
      public int compareTo(User o) {
         //return this.age.compareTo(o.age);
         int rslt;
         if (this.age < o.age) {
            rslt = -1;
         } else if (this.age > o.age) {
            rslt = 1;
         } else {
            rslt = 0;
         }
      return rslt;
      }  // */
   }

   public Set<User> sort(List<User> lst) {
      TreeSet<User> rslt = new TreeSet<User>();
      for (User user : lst) {
         rslt.add(user);
      }
   return rslt;
   }
}