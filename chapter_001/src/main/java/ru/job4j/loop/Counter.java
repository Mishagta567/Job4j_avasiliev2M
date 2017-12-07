package ru.job4j.loop;
/**
 * Первоый тестовый класс для проверки настроек.
 * @author   AVasiliev
 * @since    07.12.2017
 * @version  1.0.0
 */

public class Counter {
   /**
    * Метод должен вычислять сумму четныx чисел в диапазоне от start до finish;    *
    */
   public int add(int start, int finish) {
      int vStart, vFinish;

      // Убедимся что start > finish
      if (start >= finish) {
         vStart  = start;
         vFinish = finish;
      } else {
         vStart  = finish;
         vFinish = start;
      }

      // Теперь собственно и посчитаем.
      int vResult = 0;
      //
      for (int i = 0; ((vStart + i) <= vFinish); i++) {
         if ((vStart + 1) % 2 == 0) {
            vResult = vResult + vStart + i;
         }
      }
      return vResult;
   }
}