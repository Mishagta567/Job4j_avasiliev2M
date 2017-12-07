package ru.job4j.loop;
/**
 * Первоый тестовый класс для проверки настроек.
 * @author   AVasiliev
 * @since    07.12.2017
 * @version  1.0.0
 */

public class Factorial {

   /**
    * Функция, возвращающая факториал.
    */
   public int calc(int n) {
      int vResult = 1;
      if (n == 0) {
         //vResult = 1;
      } else {
         for (int i = 1; i <= n; i++) {
            vResult = vResult * i;
         }
      }
      return vResult;
   }
}