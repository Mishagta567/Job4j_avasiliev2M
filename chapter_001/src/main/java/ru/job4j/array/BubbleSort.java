package ru.job4j.array;

/**
 * Первоый тестовый класс для проверки настроек.
 * @author   AVasiliev
 * @since    08.12.2017
 * @version  1.0.0
 */

public class BubbleSort {
   /**
    * Метод должен вычислять сумму четныx чисел в диапазоне от start до finish;    *
    */
   public int[] sort(int[] myArray) {
      int tmp, lgth = myArray.length;
      // Повторим это дело
      for (int n = 0; n < (lgth - 1); n++) {
         for (int m = 0; m <= (lgth - 2); m++) {
            if (myArray[m] > myArray[m + 1]) {
               // переставляем значения в массиве местами
               tmp = myArray[m];
               myArray[m]     = myArray[m + 1];
               myArray[m + 1] = tmp;
            }
         }
      }
      return myArray;
   }
}