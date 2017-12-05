package ru.job4j;
/**
 * Первоый тестовый класс для проверки настроек.
 * @author   AVasiliev
 * @since    05.12.2017
 * @version  1.2
 */

public class Calculate {
   /**
    * main просто выводит почти стандартную фразу
    * "World, Hello again"
    */

   public static void main(String[] args) {
      System.out.println("Hello World");
   }

   /**
    * Method echo.
    * @param name Your name.
    * @return Echo plus your name.
    */
   public String echo(String name) {
      return "Echo, echo, echo : " + name;
   }
}