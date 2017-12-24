package ru.example.collections;

import java.util.*;

/**
 * Первоый тестовый класс для проверки настроек.
 * @author   A_Vasiliev
 * @since    22.12.2017
 * @version  1.0.0
 */

public class SetExample {

   public static void main(String[] arg) {
      Set<Integer> set = new TreeSet<>();
      set.add(3);
      set.add(1);
      set.add(4);
      set.add(2);
      set.add(5);
      set.add(100);
      set.add(102);
      set.add(105);
      set.add(6);

      for (Integer value : set) {
         System.out.println(value);
      }

   }
}