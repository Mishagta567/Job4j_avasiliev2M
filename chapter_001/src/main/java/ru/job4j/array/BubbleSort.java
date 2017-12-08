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
      int tempA, lgth = myArray.length;
      // Повторим это дело
      for (int loopA = 0; loopA < (lgth - 1) ; loopA++) {
         for (int loopB = 0; loopB <= (lgth - 2); loopB++) {
            if (myArray[loopB] > myArray[loopB + 1]) {
               // переставляем значения в массиве местами
               tempA = myArray[loopB];
               myArray[loopB]     = myArray[loopB + 1];
               myArray[loopB + 1] = tempA;
            }
         }
      }
      return myArray;
   }
}