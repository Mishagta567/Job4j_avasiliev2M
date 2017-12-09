package ru.job4j.array;

/**
 * Первоый тестовый класс для проверки настроек.
 * @author   AVasiliev
 * @since    09.12.2017
 * @version  1.0.0
 */

public class Square {
   /**
    * Метод должен строить массив из квадратов от 1 до N;    *
    */
   public int[] calculate(int bound) {
      int[] rst = new int[bound];
      //  заполнить массив через цикл элементами от 1 до bound возведенные в квадрат
      for (int i = 0; i < bound; i++) {
         rst[i] = (int) Math.pow(i + 1, 2);
      }
      return rst;
   }
}