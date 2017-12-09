package ru.job4j.array;

/**
 * Первоый тестовый класс для проверки настроек.
 * @author   AVasiliev
 * @since    08.12.2017
 * @version  1.0.0
 */

public class Turn {
   /**
    * Метод должен вычислять сумму четныx чисел в диапазоне от start до finish;    *
    */
   public int[] back(int[] array) {
      int tempA, tempB, lgth = array.length - 1;

      int half = (int) Math.floor(array.length / 2);
      for (int lp = 0; lp < half; lp++) {
         tempA = array[lp];
         tempB = array[lgth - lp];
         array[lp]        = tempB;
         array[lgth - lp] = tempA;
      }
      return array;
   }
}