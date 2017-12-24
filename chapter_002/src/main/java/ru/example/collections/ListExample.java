package ru.example.collections;

import java.util.*;

/**
 * Первоый тестовый класс для проверки настроек.
 * @author   A_Vasiliev
 * @since    22.12.2017
 * @version  1.0.0
 */

public class ListExample {

   class User {
      private List<Integer> list;
      User(List<Integer> lst) {
         this.list = lst;
      }
   }

   public static void main(String[] arg) {
      List<User> users = new ArrayList<User>();


      List<Integer> list = new ArrayList<Integer>();
      list.add(100);
      list.add(101);
      list.add(102);
      list.add(103);
      list.add(1, 1001);

      Integer values = list.get(1);
      System.out.println(values);
      System.out.println(list.indexOf(102));
   }
}