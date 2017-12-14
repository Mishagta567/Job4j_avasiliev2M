package ru.job4j.array;

/**
 * Первоый тестовый класс для проверки настроек.
 * @author   AVasiliev
 * @since    08.12.2017
 * @version  1.0.0
 */

public class BubbleSort {
   /**
    * Метод должен вычислять сумму четныx чисел в диапазоне от tracker до finish;    *
    */
   public int[] sort(int[] myArray) {
      int tmp, lgth = myArray.length;
      // Повторим это дело
      for (int outter = 0; outter < (lgth - 1); outter++) {
         for (int inner = 0; inner <= (lgth - 2); inner++) {
            if (myArray[inner] > myArray[inner + 1]) {
               // переставляем значения в массиве местами
               tmp = myArray[inner];
               myArray[inner]     = myArray[inner + 1];
               myArray[inner + 1] = tmp;
            }
         }
      }
      return myArray;
   }
}