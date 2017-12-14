package ru.job4j.loop;
/**
 * Первоый тестовый класс для проверки настроек.
 * @author   AVasiliev
 * @since    07.12.2017
 * @version  1.0.0
 */

public class Counter {
   /**
    * Метод должен вычислять сумму четныx чисел в диапазоне от tracker до finish;    *
    */
   public int add(int start, int finish) {
      int vResult = 0;
      for (int i = start; i <= finish; i++) {
         if ((i % 2) == 0) {
            vResult += i;
         }
      }
      return vResult;
   }
}