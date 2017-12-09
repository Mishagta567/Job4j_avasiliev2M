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
      for (int n = 1; n <= size; n++) {
         for (int m = 1; m <= size; m++) {
            rst[n-1][m-1] = n * m;
         }
      }
      return rst;
   }
}