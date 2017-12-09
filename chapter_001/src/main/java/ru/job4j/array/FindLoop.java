package ru.job4j.array;

/**
 * Первоый тестовый класс для проверки настроек.
 * @author   AVasiliev
 * @since    09.12.2017
 * @version  1.0.0
 */

public class FindLoop {
   /**
    * Метод должен индекс элемента в массиве, равный второму параметру. Если нет, то -1
    */
   public int indexOf(int[] data, int el) {

      int rst = -1; // если элемента нет в массиве, то возвращаем -1.

      for (int i : data){
         if (data[i] == el) {
            rst = i;
            break;
         }
      }
      return rst;
   }
}