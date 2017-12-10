package ru.job4j.array;

/**
 * Первоый тестовый класс для проверки настроек.
 * @author   AVasiliev
 * @since    09.12.2017
 * @version  1.0.0
 */

public class Matrix {
   /**
    * Делаем таблицу умножения *
    */
   public int[][] multiple(int size) {
      int[][] rst = new int[size][size];
      for (int n = 0; n < size; n++) {
         for (int m = 0; m < size; m++) {
            rst[n][m] = (n + 1) * (m + 1);
         }
      }
      return rst;
   }
}