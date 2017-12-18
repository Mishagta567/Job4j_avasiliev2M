package ru.job4j.models;
/**
 * Первоый тестовый класс для проверки настроек.
 * @author   AVasiliev
 * @since    12.12.2017
 * @version  1.0.0
 */

public class Task extends Item {
   /**
    * 
    */
   public Task(String name, String desc) {
      this.setName(name);
      this.setDescription(desc);
   }   
}