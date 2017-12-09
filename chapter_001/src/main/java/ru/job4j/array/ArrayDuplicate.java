package ru.job4j.array;

import java.util.Arrays;

/**
 * Первоый тестовый класс для проверки настроек.
 * @author   AVasiliev
 * @since    09.12.2017
 * @version  1.0.0
 */

public class ArrayDuplicate {
   /**
    * Метод должен находить дубликаты и удалять их
    */

   public String[] remove(String[] array) {
      // пройдемся
      int lgth = array.length - 1;
      int dublNumbers = 0;
      String tmp;
      for (int n = 0; n < lgth ; n++) {
         for (int m = n + 1; m <= lgth; m++) {
            // Проверяем только если мы уже не залезли в "удаленное"
            if ((n < lgth - dublNumbers)
                  && (m < lgth - dublNumbers)) {
               // только тогда выполняем проверки
               if (array[n].equals(array[m])) {
                  // убираем дубль в конец
                  tmp = array[lgth - dublNumbers];
                  array[lgth - dublNumbers] = array[m];
                  array[m] = tmp;
                  dublNumbers++;
                  // проверить бы еще раз эту же позицию, т.к. могли заменить на такой же дубль
                  m--;
               }
            }
         }
      }
      array = Arrays.copyOf(array, lgth + 1 - dublNumbers );
      return array;
   }
}