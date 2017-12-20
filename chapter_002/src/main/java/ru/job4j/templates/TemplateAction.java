package ru.job4j.templates;



/**
 * Первоый тестовый класс для проверки настроек.
 * @author   AVasiliev
 * @since    12.12.2017
 * @version  1.0.0
 */

public abstract class TemplateAction  {
   /**
    *
    */
   abstract void start();

   abstract  void finish();

   public void work() {
      this.start();
      this.finish();
   }   
}