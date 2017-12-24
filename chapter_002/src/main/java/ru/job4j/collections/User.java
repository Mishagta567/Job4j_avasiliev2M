package ru.job4j.collections;



/**
 * Первоый тестовый класс для проверки настроек.
 * @author   A_Vasiliev
 * @since    22.12.2017
 * @version  1.0.0
 */

public class User {
   private int id;
   private String name, city;

   public User(int id, String name, String city) {
      this.id = id;
      this.name = name;
      this.city = city;
   }

   public int getId() {
      return id;
   }
   public String getName() {
      return name;
   }
   public String getCity() {
      return city;
   }
}