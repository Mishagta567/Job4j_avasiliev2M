package ru.job4j.collections;

import java.util.*;

/**
 * Первоый тестовый класс для проверки настроек.
 * @author   A_Vasiliev
 * @since    22.12.2017
 * @version  1.0.0
 */

public class CheckCollections {

   LinkedList<String> ll = new LinkedList<String>();
   ArrayList<String> al  = new ArrayList<String>();
   TreeSet<String> ts    = new TreeSet<String>();
   static String testStr = "qwertyasdfghzxcvbn";
   long timeSt, timeFsh;

   void add(Collection cl) {
      for (int i = 0; i <= 100_000; i++) {
         cl.add(i + "_" + String.valueOf(System.currentTimeMillis()));
      }
   }

   void remove(Collection cl) {
      for (int i = 0; i <= 10_000; i++) {
         cl.remove(i + "_" + String.valueOf(System.currentTimeMillis()));
      }
   }

   public static void main(String[] args) {
      //System.out,print("Ya ya");
      CheckCollections tc = new CheckCollections();
      tc.timeSt = System.currentTimeMillis();  //return String.valueOf(System.currentTimeMillis() + this.position); // + RN.next());
      tc.add(tc.ll);
      tc.remove(tc.ll);
      tc.timeFsh = System.currentTimeMillis();
      System.out.println("LinkedLis: " + String.valueOf(tc.timeFsh - tc.timeSt));

      tc.timeSt = System.currentTimeMillis();  //return String.valueOf(System.currentTimeMillis() + this.position); // + RN.next());
      tc.add(tc.al);
      tc.remove(tc.al);
      tc.timeFsh = System.currentTimeMillis();
      System.out.println("ArrayList: " + String.valueOf(tc.timeFsh - tc.timeSt));

      tc.timeSt = System.currentTimeMillis();  //return String.valueOf(System.currentTimeMillis() + this.position); // + RN.next());
      tc.add(tc.ts);
      tc.remove(tc.ts);
      tc.timeFsh = System.currentTimeMillis();
      System.out.println("TreeSet: " + String.valueOf(tc.timeFsh - tc.timeSt));
      }
}