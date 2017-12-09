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
      for (int mainLoop = 0; mainLoop < (lgth - 1) ; mainLoop++) {
         for (int i = 0; i <= (lgth - 2); i++) {
            if (myArray[i] > myArray[i + 1]) {
               // переставляем значения в массиве местами
               tmp = myArray[i];
               myArray[i]     = myArray[i + 1];
               myArray[i + 1] = tmp;
            }
         }
      }
      return myArray;
   }
}